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
public enum enumContenidosGenerales {
    CONTENIDO_DISCIPLINAR {
        @Override
        public String toString() {
            return "Disciplinar";
        }
    },
    CONTENIDO_GENERICO {
        @Override
        public String toString() {
            return "Genéricas";
        }
    },
    TIPO_CONT_DISCIPLINAR_MATEMATICAS {
        @Override
        public String toString() {
            return "Matemáticas";
        }
    },
    TIPO_CONT_DISCIPLINAR_CIENCIAS_EXPERIMENTALES {
        @Override
        public String toString() {
            return "Ciencias experimentales";
        }
    },
    TIPO_CONT_DISCIPLINAR_CIENCIAS_SOCIALES {
        @Override
        public String toString() {
            return "Ciencias sociales";
        }
    },
    TIPO_CONT_DISCIPLINAR_COMUNICACION {
        @Override
        public String toString() {
            return "Comunicación";
        }
    },
    TIPO_CONT_GENERICO_AUTODETERMINA {
        @Override
        public String toString() {
            return "Se autodetermina y cuida de sí";
        }
    },
    TIPO_CONT_GENERICO_EXPRESA {
        @Override
        public String toString() {
            return "Se expresa y comunica";
        }
    },
    TIPO_CONT_GENERICO_PIENSA {
        @Override
        public String toString() {
            return "Piensa crítica y reflexivamente";
        }
    },
    TIPO_CONT_GENERICO_TRABAJA {
        @Override
        public String toString() {
            return "Trabaja en forma colaborativa";
        }
    },
    TIPO_CONT_GENERICO_PARTICIPA {
        @Override
        public String toString() {
            return "Participa con responsabilidad en la sociedad";
        }
    },
    TIPO_CONT_GENERICO_APRENDE {
        @Override
        public String toString() {
            return "Aprende de forma autónoma";
        }
    },
    TIPO_CONT_GENERICO_EVIDENCIAS {
        @Override
        public String toString() {
            return "Evidencias";
        }
    },
    TIPO_CONT_GENERICO_INSTRUMENTOS {
        @Override
        public String toString() {
            return "InstrumentosDeEvaluación";
        }
    }
    
}
