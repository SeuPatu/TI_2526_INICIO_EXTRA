#include <iostream>
#include <string.h>
using namespace std;

int main(int argc, char** argv) {
	
	int anoLivro[5],i,a;
	string tituloLivro[5];
	
	cout << "Quantos Livros Deseja Adicionar?\nValor: ";
	cin >> i;
	
	for (a=0; a<i; a++){
		
		cout << "\nTitulo do Livro "<< a+1 <<": ";
		cin >> tituloLivro[a];
		
		cout << "Ano do Livro "<< a+1 <<": ";
		cin >> anoLivro[a];
	
	}
	return 0;
}