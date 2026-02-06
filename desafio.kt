// Define os niveis fixos possiveis da Formacao
// enum -> Conjunto fechado de opcoes para o nível da formacao (nao aceita qualquer texto)
enum class Nivel { Basico, Intermediario, Avancado }

// Representa um Conteudo Educacional (aulas, projetos, materiais, etc)
data class ConteudoEducacional(val nome: String, val cargaHoraria: Int)

// Representa um Aluno (nome e id)
data class Aluno(val id: String, val nome: String)

// Representa a Formacao (nome, nivel e lista de conteudos, alem de suas funcoes)
class Formacao(val nome: String, val nivel: Nivel, val conteudos: MutableSet<ConteudoEducacional>)

fun main() {
    TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}
