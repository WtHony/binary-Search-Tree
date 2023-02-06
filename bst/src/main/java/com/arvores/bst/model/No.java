package com.arvores.bst.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class No<T extends Comparable<T>> {

    @NonNull
    private T dados;

    private No<T> esquerda;
    private No<T> direita;

}