/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricasconcretas;

import fabricaabstrata.CategoriaAbstrata;

/**
 *
 * @author Rodrigo Leite
 */
public enum SCategoria {
    
    CATEGORIA_A{
        @Override
        public CategoriaAbstrata getInstance() {
            return new CategoriaA();
        }
        
    },
    CATEGORIA_B{
        @Override
        public CategoriaAbstrata getInstance() {
            return new CategoriaB();
        }
    },
    CATEGORIA_C{
        @Override
        public CategoriaAbstrata getInstance() {
            return new CategoriaC();
        }
    },
    CATEGORIA_INICIANTE{
        @Override
        public CategoriaAbstrata getInstance() {
            return new CategoriaIniciante();
        }
    };
    
    public abstract CategoriaAbstrata getInstance();
}
