package com.game.rpg.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.game.rpg.entity.itens.Item;
import com.game.rpg.mapper.ItemRowMapper;

@Repository
public class ItemRepository {

    private NamedParameterJdbcTemplate template;

    public ItemRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public void createItem(Item item) {
        String sql = "INSERT INTO Item (nome, descricao, elemento, reforja, raridade, tipo_de_peca, dano_fisico, dano_magico, defesa_fisica, defesa_magica, imagem) "
                +
                "VALUES (:nome, :descricao, :elemento, :reforja, :raridade, :tipoDePeca, :danoFisico, :danoMagico, :defesaFisica, :defesaMagica, :imagem)";

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("nome", item.getNome());
        parameters.addValue("descricao", item.getDescricao());
        parameters.addValue("elemento", item.getElemento());
        parameters.addValue("reforja", item.getReforja());
        parameters.addValue("raridade", item.getRaridade());
        parameters.addValue("tipoDePeca", item.getTipoDePeca());
        parameters.addValue("danoFisico", item.getDanoFisico());
        parameters.addValue("danoMagico", item.getDanoMagico());
        parameters.addValue("defesaFisica", item.getDefesaFisica());
        parameters.addValue("defesaMagica", item.getDefesaMagica());
        parameters.addValue("imagem", item.getImagem());

        template.update(sql, parameters);

    }

    public void updateItemField(long itemId, String fieldName, Object newValue) {
        String sql = "UPDATE Item SET " + fieldName + " = :newValue WHERE id = :itemId";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("newValue", newValue);
        parameters.put("itemId", itemId);

        template.update(sql, parameters);
    }

    public Item findById(long itemId) {
        String sql = "SELECT * FROM Item WHERE id = :itemId";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("itemId", itemId);

        return template.queryForObject(sql, paramMap, new ItemRowMapper());
    }

    public List<Item> findItemsByFilters(String nome, String descricao, String elemento, Integer reforja,
            String raridade, String tipoDePeca, Integer danoFisico,
            Integer danoMagico, Integer defesaFisica, Integer defesaMagica) {

        StringBuilder sql = new StringBuilder("SELECT * FROM Item WHERE 1=1 ");
        MapSqlParameterSource parameters = new MapSqlParameterSource();

        if (nome != null) {
            sql.append("AND nome LIKE CONCAT('%', :nome, '%')");
            parameters.addValue("nome", nome);
        }

        if (descricao != null) {
            sql.append("AND descricao = :descricao ");
            parameters.addValue("descricao", descricao);
        }

        if (elemento != null) {
            sql.append("AND elemento = :elemento ");
            parameters.addValue("elemento", elemento);
        }

        if (reforja != null) {
            sql.append("AND reforja = :reforja ");
            parameters.addValue("reforja", reforja);
        }

        if (raridade != null) {
            sql.append("AND raridade = :raridade ");
            parameters.addValue("raridade", raridade);
        }

        if (tipoDePeca != null) {
            sql.append("AND tipo_de_peca = :tipoDePeca ");
            parameters.addValue("tipoDePeca", tipoDePeca);
        }

        if (danoFisico != null) {
            sql.append("AND dano_fisico = :danoFisico ");
            parameters.addValue("danoFisico", danoFisico);
        }

        if (danoMagico != null) {
            sql.append("AND dano_magico = :danoMagico ");
            parameters.addValue("danoMagico", danoMagico);
        }

        if (defesaFisica != null) {
            sql.append("AND defesa_fisica = :defesaFisica ");
            parameters.addValue("defesaFisica", defesaFisica);
        }

        if (defesaMagica != null) {
            sql.append("AND defesa_magica = :defesaMagica ");
            parameters.addValue("defesaMagica", defesaMagica);
        }

        return template.query(sql.toString(), parameters, new ItemRowMapper());
    }
}
