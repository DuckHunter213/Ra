/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author gerar
 */
public enum enumContenidosEspecificos {
    CONTENIDO_PROCEDIMENTAL {
        @Override
        public String toString() {
            return "procedimentales";
        }
    },
    CONTENIDO_DECLARATIVO {
        @Override
        public String toString() {
            return "declarativo";
        }
    },
    CONTENIDO_ACTITUDINAL {
        @Override
        public String toString() {
            return "actitudinal";
        }
    },
    MATERIA_FISICA {
        @Override
        public String toString() {
            return "Física";
        }
    },
    MATERIA_MATEMATICAS {
        @Override
        public String toString() {
            return "Matemáticas";
        }
    },
    SEMESTRE_1 {
        @Override
        public String toString() {
            return "1";
        }
    },
    SEMESTRE_2 {
        @Override
        public String toString() {
            return "2";
        }
    },
    SEMESTRE_3 {
        @Override
        public String toString() {
            return "3";
        }
    },
    BLOQUE_1 {
        @Override
        public String toString() {
            return "1";
        }
    },
    BLOQUE_2 {
        @Override
        public String toString() {
            return "2";
        }
    },
    BLOQUE_3 {
        @Override
        public String toString() {
            return "3";
        }
    },
    BLOQUE_4 {
        @Override
        public String toString() {
            return "4";
        }
    },

}
