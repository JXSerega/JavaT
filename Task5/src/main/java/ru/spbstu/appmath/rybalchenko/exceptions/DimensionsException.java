package ru.spbstu.appmath.rybalchenko.exceptions;


public class DimensionsException extends MatrixCalcException{
    public DimensionsException() {
        super("File doesn't contain valid data");
    }
}
