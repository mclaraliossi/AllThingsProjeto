package br.com.allthings.allthings.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProduto;

    @Column(nullable = false, length = 50)
    private String descricaoProduto;

    @Column(nullable = false, length = 50)
    private String marcaProduto;

    @Column(nullable = false, length = 50)
    private String modeloProduto;

    @Column(nullable = false, length = 50)
    private String unidadeProduto;

    @Column(nullable = false)
    private double valorProduto;

    @ManyToOne
    @JoinColumn(name = "idFornecedor_fk")
    private Fornecedor fornecedor;
    
    @ManyToOne
    @JoinColumn(name = "idCategoria_fk")
    private Categoria categoria;
    

}
