package com.iftm.nosql.rediscassandra.services;

package com.iftm.nosql.rediscassandra.entities.Imovel;
package com.iftm.nosql.rediscassandra.repositories.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImovelService {
    @Autowired
    private ImovelRepository repository;

    @Cacheable(value = "imoveis")
    public List<TipoImovel> findAll(){
        return repository.findAll();
    }

    @Cacheable(value = "imoveis", key = "#id")
    public Imovel findById(UUID id) throws Exception{
        return repository.findById(id).orElseThrow(()-> new Exception("Imóvel com ID " + id + " não encontrado."));
    }
    @CacheEvict(value = "imoveis", allEntries = true)
    public Imovel save(Imovel imovel) throws Exception {
        if(imovel == null)
            throw new IllegalArgumentException("O imóvel não pode ser nulo.");
        return repository.save(imovel);
    }

    @CacheEvict(value = "imoveis", allEntries = true)
    public Imovel update(Imovel imovel) throws Exception{
        if(imovel.getId() == null)
            throw new Exception("O ID do imóvel não pode ser nulo.");

        var dbImovel = repository.findById(imovel.getId());
        if(dbImovel.isEmpty())
            throw new Exception("Imóvel com ID " + imovel.getId() + " não encontrado.");

        var curImovel = dbImovel.get();
        curImovel.setEndereco(imovel.getEndereco());
        curImovel.setTipo_imovel(imovel.getTipo_imovel());
        curImovel.setArea(imovel.getArea());
        curImovel.setPreco(imovel.getPreco());
        return repository.save(curImovel);
    }

    @CacheEvict(value = "imoveis", allEntries = true)
    public void delete(UUID id) throws Exception {
        if(!repository.existsById(id)){
            throw new Exception("Imóvel com ID " + id + " não existe e não pode ser deletado.");
        }
        repository.deleteById(id);


    }

}
