package jp.co.sample.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administer;

/**
 * @author sawaguchiarisa
 *レポジトリークラスです
 */
@Repository
public class AdministratorRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Administer> ADMINISTRATOR_ROW_MAPPER=(rs,i) ->{
		Administer administer = new Administer();
		administer.setId(rs.getInt("id"));
		administer.setMailAddress(rs.getString("mail_address"));
		administer.setName(rs.getString("name"));
		administer.setPassword(rs.getString("password"));
		return administer;
	};
	/**
	 * 管理者情報を挿入する
	 * @param administer
	 */
	public void insert(Administer administer) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(administer);
		String insertsql = "INSERT INTO administrators (name,mail_address,password)"
				+ "VALUES (:name,:mailAddress,:password)";
		template.update(insertsql, param);
		System.out.println("insertが呼ばれた");
	}
	/**
	 * メールアドレスとパスワードから管理者情報を取得する
	 * @param mailAddress,password
	 * @return 検索された管理情報
	 */
	public Administer findByMailAddressAndPassword(String mailAddress, String password) {
		String selectsql="SELECT id,name,mail_address,password FROM administrators WHERE mail_address=:mailAddress AND password=:password";
		try {
			SqlParameterSource param = new MapSqlParameterSource().addValue("password", password).addValue("mailAddress", mailAddress);
			Administer administer = template.queryForObject(selectsql, param, ADMINISTRATOR_ROW_MAPPER);
			System.out.println("findByMailAddressAndPasswordが呼ばれた");
			return administer;
			
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			return null;
		}
	}
}
