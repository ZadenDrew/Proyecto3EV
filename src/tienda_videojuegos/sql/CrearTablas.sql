/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  andrea
 * Created: 23-may-2018
 */

CREATE TABLE JUEGOS(
    CODIGO VARCHAR2(10),
    NOMBRE VARCHAR2(15) NOT NULL,
    CONSOLA VARCHAR2(15) NOT NULL,
    PRECIO DECIMAL(3) NOT NULL,
    UNIDADES INTEGER(3) NOT NULL
);
