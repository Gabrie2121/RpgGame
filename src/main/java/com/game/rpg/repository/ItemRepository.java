package com.game.rpg.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.game.rpg.entity.itens.Item;
import com.game.rpg.enums.Elements;
import com.game.rpg.enums.ItemType;
import com.game.rpg.enums.Rarity;
import com.game.rpg.mapper.ItemRowMapper;

@Repository
public class ItemRepository {

    private NamedParameterJdbcTemplate template;

    public ItemRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public void createItem(Item item) {
        String sql = "INSERT INTO Item (nome, descricao, elemento, raridade, tipo_de_peca, forca, destreza, inteligencia, constituicao,sorte, imagem) "
                +
                "VALUES (:nome, :descricao, :elemento, :raridade, :tipoDePeca, :forca, :destreza, :inteligencia, :constituicao, :sorte, :imagem)";
        System.out.println(item.getNome());
        MapSqlParameterSource parameters = new MapSqlParameterSource();

        parameters.addValue("nome", item.getNome());
        parameters.addValue("descricao", item.getDescricao());
        parameters.addValue("elemento", item.getElemento());
        parameters.addValue("raridade", item.getRaridade());
        parameters.addValue("tipoDePeca", item.getTipoDePeca());
        parameters.addValue("forca", item.getForca());
        parameters.addValue("destreza", item.getDestreza());
        parameters.addValue("inteligencia", item.getInteligencia());
        parameters.addValue("constituicao", item.getConstituicao());
        parameters.addValue("sorte", item.getSorte());
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

    public List<Item> findItemsByFilters(String nome, String descricao, String elemento,
            String raridade, String tipoDePeca) {

        StringBuilder sql = new StringBuilder("SELECT id, nome, descricao FROM Item WHERE 1=1 ");
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

        if (raridade != null) {
            sql.append("AND raridade = :raridade ");
            parameters.addValue("raridade", raridade);
        }

        if (tipoDePeca != null) {
            sql.append("AND tipo_de_peca = :tipoDePeca ");
            parameters.addValue("tipoDePeca", tipoDePeca);
        }

        List<Item> result = template.query(sql.toString(), parameters, (rs, i) -> {
            Item item = new Item();
            item.setId((Long) rs.getLong("id"));
            item.setNome((String) rs.getString("nome"));
            item.setDescricao((String) rs.getString("descricao"));
            return item;
        });

        return result;
    }
}
