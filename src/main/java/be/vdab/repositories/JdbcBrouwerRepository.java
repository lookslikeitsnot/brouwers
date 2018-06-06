package be.vdab.repositories;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import be.vdab.entities.Brouwer;
import be.vdab.valueobjects.Adres;
import be.vdab.valueobjects.Naam;

@Repository
public class JdbcBrouwerRepository implements BrouwerRepository {
	private final JdbcTemplate jdbcTemplate;
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private final RowMapper<Brouwer> rowMapper = (resultSet, rowNum) -> new Brouwer(resultSet.getLong("id"),
			resultSet.getString("naam"), resultSet.getInt("omzet"), new Adres(resultSet.getString("straat"),
					resultSet.getString("huisNr"), resultSet.getInt("postcode"), resultSet.getString("gemeente")));
	private final SimpleJdbcInsert simpleJdbcInsert;
	
	private static final String BEGIN_SQL = "select id, naam, omzet, straat, huisNr, postcode, gemeente from brouwers ";
	private static final String SQL_FIND_ALL = BEGIN_SQL + "order by naam";
	private static final String SQL_FIND_BY_NAAM = BEGIN_SQL + "where naam LIKE :naam";

	JdbcBrouwerRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
		simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("brouwers");
		simpleJdbcInsert.usingGeneratedKeyColumns("id");
	}

	@Override
	public void create(Brouwer brouwer) {
		Map<String, Object> kolomWaarden = new HashMap<>();
		kolomWaarden.put("naam", brouwer.getNaam());
		kolomWaarden.put("omzet", brouwer.getOmzet());
		kolomWaarden.put("straat", brouwer.getAdres().getStraat());
		kolomWaarden.put("huisNr", brouwer.getAdres().getHuisNr());
		kolomWaarden.put("postcode", brouwer.getAdres().getPostcode());
		kolomWaarden.put("gemeente", brouwer.getAdres().getGemeente());
		Number id = simpleJdbcInsert.executeAndReturnKey(kolomWaarden);
		brouwer.setBrouwerNr(id.longValue());
	}

	@Override
	public List<Brouwer> findAll() {
		return jdbcTemplate.query(SQL_FIND_ALL, rowMapper);
	}

	@Override
	public List<Brouwer> findByNaam(Naam beginNaam) {
		Map<String, String> parameters = Collections.singletonMap("naam", beginNaam.getName()+"%");
		return namedParameterJdbcTemplate.query(SQL_FIND_BY_NAAM, parameters, rowMapper);
	}

	@Override
	public List<Brouwer> findByLetter(String letter) {
		Map<String, String> parameters = Collections.singletonMap("naam", letter+"%");
		return namedParameterJdbcTemplate.query(SQL_FIND_BY_NAAM, parameters, rowMapper);
	}
}
