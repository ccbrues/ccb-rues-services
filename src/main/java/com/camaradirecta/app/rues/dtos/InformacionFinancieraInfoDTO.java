package com.camaradirecta.app.rues.dtos;

import java.io.Serializable;
import java.util.ArrayList;

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
    public double fijo_neto;
    public int otros_activos;
    public int valorizaciones;
    public int activo_total;
    public int pasivo_corriente;
    public int largo_plazo;
    public int pasivo_total;
    public int patrimonio;
    public int ingresos_operacionales;
    public int ingresos_no_operacionales;
    public int gastos_operacionales;
    public int gastos_no_operacionales;
    public int costo_ventas;
    public int gastos_intereses;
    public int utilidad_perdida_operacional;
    public int utilidad_perdida_neta;
    public int indice_liquidez;
    public int indice_endeudamiento;
    public int razon_cobertura_intereses;
    public int rentabilidad_patrimonio;
    public int rentabilidad_activo;
    public ArrayList<String> clasificacion_unspsc;
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
