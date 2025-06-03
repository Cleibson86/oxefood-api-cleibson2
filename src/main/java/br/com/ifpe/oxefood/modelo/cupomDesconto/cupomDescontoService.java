package br.com.ifpe.oxefood.modelo.cupomdesconto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CupomDescontoService {

    @Autowired
   private CupomDescontoRepository repository;

   @Transactional
   public CupomDesconto save(CupomDesconto CupomDesconto) {

       cupomDesconto.setHabilitado(Boolean.TRUE);
       return repository.save(cupomDesconto);
   }
   public List<CupomDesconto> listarTodos() {
  
    return repository.findAll();
}

public CupomDesconto obterPorID(Long id) {

    return repository.findById(id).get();
}
@Transactional
public void update(Long id, CupomDesconto CupomDescontoAlterado) {

   CupomDesconto cupomDesconto = repository.findById(id).get();
   cupomDesconto.setNome(cupomDescontoAlterado.getNome());
   cupomDesconto.setDataNascimento(cupomDescontoAlterado.getDataNascimento());
   cupomDesconto.setCpf(cupomDescontoAlterado.getCpf());
   cupomDesconto.setFoneCelular(cupomDescontoAlterado.getFoneCelular());
   cupomDesconto.setFoneFixo(cupomDescontoAlterado.getFoneFixo());
     
   repository.save(cupomDesconto);
}

@Transactional
   public void delete(Long id) {

       CupomDesconto cupomDesconto = repository.findById(id).get();
       cupomDesconto.setHabilitado(Boolean.FALSE);

       repository.save(cupomDesconto);
   }


}
