package com.game.rpg.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.game.rpg.entity.itens.Item;
import com.game.rpg.repository.ItemRepository;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void createItem(Item item, MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                String diretorio = "C:/TAREFAS/ProjetoGame/images/";
                String nomeArquivo = item.getNome() + ".jpeg";
                file.transferTo(new File(diretorio + nomeArquivo));

                item.setImagem(nomeArquivo);
            }

        } catch (Exception e) {
        }

        itemRepository.createItem(item);
    }

    public void updateItemField(long itemId, String fieldName, Object newValue) {
        itemRepository.updateItemField(itemId, fieldName, newValue);
    }

    public Item findById(long itemId) {
        return itemRepository.findById(itemId);
    }

    public List<Item> findItemsByFilters(String nome, String descricao, String elemento,
            String raridade, String tipoDePeca) {
        return itemRepository.findItemsByFilters(nome, descricao, elemento, raridade, tipoDePeca);
    }
}
