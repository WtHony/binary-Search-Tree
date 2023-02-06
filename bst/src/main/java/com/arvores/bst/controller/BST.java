package com.arvores.bst.controller;

import com.arvores.bst.model.Arvore;
import com.arvores.bst.model.No;

public class BST<T extends Comparable<T>> implements Arvore<T> {

    private No<T> no;

    @Override
    public Arvore<T> inserir(T dados) {
        no = inserir(dados, no);
        return this;
    }

    private No<T> inserir(T dados, No<T> no) {
        if (no == null) {
            return new No<>(dados);
        }
        if (dados.compareTo(no.getDados()) < 0) {
            no.setEsquerda(inserir(dados, no.getEsquerda()));
        } else if (dados.compareTo(no.getDados()) > 0) {
            no.setDireita(inserir(dados, no.getDireita()));
        }
        return no;
    }

    @Override
    public void excluir(T dados) {
        no = excluir(dados, no);
    }

    private No<T> excluir(T dados, No<T> no) {
        if (no == null) {
            return null;
        }
        if (dados.compareTo(no.getDados()) < 0) {
            no.setEsquerda(excluir(dados, no.getEsquerda()));
        } else if (dados.compareTo(no.getDados()) > 0) {
            no.setDireita(excluir(dados, no.getDireita()));
        } else {
            if (no.getEsquerda() == null) {
                return no.getDireita();
            } else if (no.getDireita() == null) {
                return no.getEsquerda();
            }

            no.setDados(noMax(no.getEsquerda()));
            no.setEsquerda(excluir(no.getDados(), no.getEsquerda()));
        }

        return no;
    }

    @Override
    public void percorrer() {
        preOrdem(no);
    }

    private void preOrdem(No<T> no) {
        if (no == null) {
            return;
        }
        System.out.println(no);
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    @Override
    public T noMax() {
        if (isVazio()) {
            return null;
        }
        return noMax(no);
    }

    private T noMax(No<T> no) {
        if (no.getDireita() != null) {
            return noMax(no.getDireita());
        }
        return no.getDados();
    }

    @Override
    public T noMin() {
        if (isVazio()) {
            return null;
        }
        return noMin(no);
    }

    private T noMin(No<T> no) {
        if (no.getEsquerda() != null) {
            return noMin(no.getEsquerda());
        }
        return no.getDados();
    }

    @Override
    public boolean isVazio() {
        return no == null;
    }
}