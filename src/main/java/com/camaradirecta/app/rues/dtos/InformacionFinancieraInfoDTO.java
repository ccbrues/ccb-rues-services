package com.camaradirecta.app.rues.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformacionFinancieraInfoDTO implements Serializable{

	public String fecha_corte_informacion_financiera;
    public double activo_corriente;
    public int activo_no_corriente;
    public int activo_total;
    public int pasivo_corriente;
    public int largo_plazo;
    public int pasivo_total;
    public int ingresos_operacionales;
    public int ingresos_no_operacionales;
    public int gastos_operacionales;
    public int gastos_no_operacionales;
    public int costo_ventas;
    public int gastos_intereses;
    public int utilidad_perdida_operacional;
    public int utilidad_perdida_neta;
    public double indice_liquidez;
    public double indice_endeudamiento;
    public double razon_cobertura_intereses;
    public double rentabilidad_patrimonio;
    public double rentabilidad_activo;
    public int patrimonio_neto;
    public int pasivo_patrimonio;
    public int balance_social;
    public int gastos_impuestos;
    public int gastos_financieros;
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
