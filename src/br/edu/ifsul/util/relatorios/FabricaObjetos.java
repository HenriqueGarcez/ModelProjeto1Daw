/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util.relatorios;

import br.edu.ifsul.modelo.Livraria;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author henri
 */
public class FabricaObjetos {
    
    public static List<Livraria> carregaLivrarias(){
        List<Livraria> lista = new ArrayList<>();
        Livraria l1 = new Livraria();
        l1.setNome("Nobel");
        l1.setSite("nobel.com");
        lista.add(l1);
        Livraria l3 = new Livraria();
        l3.setNome("Nacional");
        l3.setSite("nacional.com");
        lista.add(l3);        
        return lista;        
    }

    
   /* public static List<Produto> listaProdutos() {
        List<Produto> lista = new ArrayList<>();
        Grupo g = new Grupo();
        g.setNome("Eletrônicos");
        Marca samsung = new Marca();
        samsung.setNome("Samsung");
        Marca dell = new Marca();
        dell.setNome("Dell");
        Produto p1 = new Produto();
        p1.setNome("Mouse Laser");
        p1.setDescricao("Mouse com alta precisão");
        p1.setPreco(130.00);
        p1.setEstoque(40.0);
        p1.setGrupo(g);
        p1.setMarca(dell);
        Produto p2 = new Produto();
        p2.setNome("Impressora Deskjet");
        p2.setDescricao("Impressora jato de Tinta");
        p2.setPreco(180.00);
        p2.setEstoque(3.0);
        p2.setGrupo(g);
        p2.setMarca(samsung);
        Produto p3 = new Produto();
        p3.setNome("HD USB 1TB");
        p3.setDescricao("HD Externo USB 1TB");
        p3.setPreco(450.00);
        p3.setEstoque(30.0);
        p3.setGrupo(g);
        p3.setMarca(samsung);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        return lista;
    }    
    
   public static List<Venda> carregaVenda(){
       List<Venda> lista = new ArrayList<>();
       PessoaFisica cliente = new PessoaFisica();
       cliente.setNome("João da Silva");
       Usuario vendedor = new Usuario();
       vendedor.setNome("Alex ");
       Produto p = new Produto();
       p.setNome("Projeto HDMI");
       Venda v = new Venda();
       v.setData(Calendar.getInstance());
       v.setPagamento("A prazo");
       v.setPessoaFisica(cliente);
       v.setQuantidadeParcelas(6);
       v.setUsuario(vendedor);
       v.setValorTotal(2000.00);
       VendaItens vi = new VendaItens();
       vi.setProduto(p);
       vi.setQuantidade(1.0);
       vi.setValorUnitario(2000.00);
       vi.setValorTotal(2000.00);
       v.adicionarItem(vi);
       lista.add(v);
       return lista;
   } */
}
