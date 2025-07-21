    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package com.gbatallas.backendbanco.dto;

    import java.time.LocalDate;
import java.util.Date;


    /**
     *
     * @author gfbat
     */
    public class MovimientoReporteDto {

        private Date fecha;
        private String nombre;
        private Long numeroCuenta;
        private String tipo;
        private Long saldoInicial;
        private Boolean estado;
        private Long valor;
        private Long saldoDisponible;
        
        public MovimientoReporteDto(){}
        

        public MovimientoReporteDto(
         Date fecha,
         String nombre,
         Long numeroCuenta,
         String tipo,
         Long saldoInicial,
         Boolean estado,
         Long valor,
         Long saldoDisponible
        ){
        this.fecha=fecha;
        this.nombre=nombre;
        this.numeroCuenta=numeroCuenta;
        this.tipo=tipo;
        this.saldoInicial= saldoInicial;
        this.estado=estado;
        this.valor = valor;
        this.saldoDisponible=saldoDisponible;
    }

        /**
         * @return the fecha
         */
        public Date getFecha() {
            return fecha;
        }

        /**
         * @return the nombre
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * @return the numeroCuenta
         */
        public Long getNumeroCuenta() {
            return numeroCuenta;
        }

        /**
         * @return the tipo
         */
        public String getTipo() {
            return tipo;
        }

        /**
         * @return the saldoInicial
         */
        public Long getSaldoInicial() {
            return saldoInicial;
        }

        /**
         * @return the estado
         */
        public Boolean getEstado() {
            return estado;
        }

        /**
         * @return the valor
         */
        public Long getValor() {
            return valor;
        }

        /**
         * @return the saldoDisponible
         */
        public Long getSaldoDisponible() {
            return saldoDisponible;
        }

        /**
         * @param fecha the fecha to set
         */
        public void setFecha(Date fecha) {
            this.fecha = fecha;
        }

        /**
         * @param nombre the nombre to set
         */
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        /**
         * @param numeroCuenta the numeroCuenta to set
         */
        public void setNumeroCuenta(Long numeroCuenta) {
            this.numeroCuenta = numeroCuenta;
        }

        /**
         * @param tipo the tipo to set
         */
        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        /**
         * @param saldoInicial the saldoInicial to set
         */
        public void setSaldoInicial(Long saldoInicial) {
            this.saldoInicial = saldoInicial;
        }

        /**
         * @param estado the estado to set
         */
        public void setEstado(Boolean estado) {
            this.estado = estado;
        }

        /**
         * @param valor the valor to set
         */
        public void setValor(Long valor) {
            this.valor = valor;
        }

        /**
         * @param saldoDisponible the saldoDisponible to set
         */
        public void setSaldoDisponible(Long saldoDisponible) {
            this.saldoDisponible = saldoDisponible;
        }

    }

