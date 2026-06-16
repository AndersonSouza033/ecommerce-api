package ecommerce.bd.service;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Service;

import ecommerce.bd.dto.PedidoClienteLookupDTO;
import ecommerce.bd.dto.RelatorioProdutoVendidoDTO;
import ecommerce.bd.dto.RelatorioStatusDTO;

@Service
public class RelatorioService {

    private final MongoTemplate mongoTemplate;

    public RelatorioService(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    public List<RelatorioStatusDTO> pedidosPorStatus(){
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("status").count().as("quantidade"),
                Aggregation.project("quantidade").and("_id").as("status"));

        return mongoTemplate.aggregate(aggregation,"pedidos", RelatorioStatusDTO.class).getMappedResults();
    }

    public List<RelatorioProdutoVendidoDTO> produtosMaisVendidos(){
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.unwind("itens"),
                Aggregation.group("itens.produtoId").sum("itens.quantidade").as("quantidadeVendida"),
                Aggregation.project("quantidadeVendida").and("_id").as("produtoId"));

        return mongoTemplate.aggregate(aggregation,"pedidos",RelatorioProdutoVendidoDTO.class).getMappedResults();
    }

    public List<PedidoClienteLookupDTO> pedidosComCliente(){
        Aggregation aggregation = Aggregation.newAggregation(
            Aggregation.lookup("clientes","clienteId","_id","cliente"));

        return mongoTemplate.aggregate(aggregation,"pedidos",PedidoClienteLookupDTO.class).getMappedResults();
    }
}