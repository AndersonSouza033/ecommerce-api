const URL =
    "http://localhost:8080/categorias";

function exibirResultado(dados){

    document.getElementById("resultado")
        .textContent =
            JSON.stringify(dados,null,4);
}

async function listarCategorias(){

    const resposta =
        await fetch(URL);

    const dados =
        await resposta.json();

    exibirResultado(dados);
}

async function cadastrarCategoria(){

    const categoria = {

        nomeCategoria:
            document.getElementById("nomeCategoria").value,

        descricao:
            document.getElementById("descricaoCategoria").value
    };

    const resposta =
        await fetch(URL,{

            method:"POST",

            headers:{
                "Content-Type":
                "application/json"
            },

            body:
                JSON.stringify(categoria)
        });

    const dados =
        await resposta.json();

    exibirResultado(dados);
}

async function buscarPorNome(){

    const nome =
        document.getElementById("buscarNome").value;

    const resposta =
        await fetch(
            `${URL}/nome?nomeCategoria=${nome}`
        );

    const dados =
        await resposta.json();

    exibirResultado(dados);
}

async function buscarNomeOuDescricao(){

    const nome =
        document.getElementById("buscarNomeOr").value;

    const descricao =
        document.getElementById("buscarDescricaoOr").value;

    const resposta =
        await fetch(
            `${URL}/or?nomeCategoria=${nome}&descricao=${descricao}`
        );

    const dados =
        await resposta.json();

    exibirResultado(dados);
}

async function atualizarCategoria(){

    const id =
        document.getElementById("idAtualizar").value;

    const categoria = {

        nomeCategoria:
            document.getElementById("nomeAtualizar").value,

        descricao:
            document.getElementById("descricaoAtualizar").value
    };

    const resposta =
        await fetch(`${URL}/${id}`,{

            method:"PUT",

            headers:{
                "Content-Type":
                "application/json"
            },

            body:
                JSON.stringify(categoria)
        });

    const dados =
        await resposta.json();

    exibirResultado(dados);
}

async function atualizarCategoria(){

    const id =
        document.getElementById("idAtualizar").value;

    const categoria = {

        nomeCategoria:
            document.getElementById("nomeAtualizar").value,

        descricao:
            document.getElementById("descricaoAtualizar").value
    };

    const resposta =
        await fetch(`${URL}/${id}`,{

            method:"PUT",

            headers:{
                "Content-Type":
                "application/json"
            },

            body:
                JSON.stringify(categoria)
        });

    const dados =
        await resposta.json();

    exibirResultado(dados);
}