package com.arvores.bst;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arvores.bst.controller.BST;
import com.arvores.bst.model.Arvore;

@SpringBootApplication
public class BstApplication {

	public static void main(String[] args) {

		Arvore<Integer> bst = new BST<>();
		bst.inserir(10).inserir(4).inserir(8).inserir(12).inserir(16).inserir(18);
		bst.percorrer();

		System.out.println("Maior nó: " + bst.noMax());
		System.out.println("Menor nó: " + bst.noMin());

		System.out.println("Excluindo nó... " + bst.noMax());
		bst.excluir(bst.noMax());
		System.out.println("Maior nó: " + bst.noMax());
		System.out.println("Menor nó: " + bst.noMin());
		bst.percorrer();
	}
}
