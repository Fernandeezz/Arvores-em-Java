public class Arvore {
    private Elemento ele;
    private Arvore esquerda;
    private Arvore direita;

    public Arvore(Elemento ele) {
        this.ele = ele;
        this.direita = null;
        this.esquerda = null;
        System.out.println("Criei a arvore com o elemento: " + ele.getValor());
    }
    //precisamos criar um elemento e saber se ela está null.
    public boolean isEmpty() {
        return (this.ele == null);
    }
    //verifica se a arvore está vazia
    public void adicionar (Elemento novo){
        if (isEmpty()){ //se a arvore já tiver elemento vamos criar uma nova arvore
            ele = novo;
        }else {
            Arvore novaArvore= new Arvore(novo); //estará a direita ou a esquerda
            if(novo.getValor()< this.ele.getValor()) { { //se o novo valor for menor que o elemento da arvore
                if(this.esquerda==null) {//sou uma folha
                    this.esquerda=novaArvore;
                    System.out.println("O elemento : "+novo.getValor()+" adicionado à esquerda do valor :"+this.ele.getValor());
                }else {
                    this.esquerda.adicionar(novo);
                }
        }else if(novo.getValor()>this.ele.getValor()) {

                if (this.direita == null) {
                    this.direita = novaArvore;

                    System.out.println("O elemento :" + novo.getValor() + " adicionado à direita do valor " + this.ele.getValor());

                } else {
                    this.direita.adicionar(novo);
                }
            }
        }
    }
}
