const URL =
    "http://localhost:8080/pedidos";

function exibirResultado(dados){

    document.getElementById("resultado")
        .textContent =
        JSON.stringify(dados,null,4);
}

async function listarPedidos(){

    const resposta =
        await fetch(URL);

    exibirResultado(await resposta.json());
}

async function cadastrarPedido(){

    const pedido = {

        clienteId:
            document.getElementById("clienteId").value,

        status:
            document.getElementById("statusPedido").value,

        total:
            parseFloat(
                document.getElementById("totalPedido").value
            )
    };

    const resposta =
        await fetch(URL,{

            method:"POST",

            headers:{
                "Content-Type":
                "application/json"
            },

            body:
                JSON.stringify(pedido)
        });

    exibirResultado(await resposta.json());
}

async function buscarPorCliente(){

    const clienteId =
        document.getElementById("clienteBusca").value;

    const resposta =
        await fetch(
            `${URL}/cliente/${clienteId}`
        );

    exibirResultado(await resposta.json());
}

async function buscarPorCliente(){

    const clienteId =
        document.getElementById("clienteBusca").value;

    const resposta =
        await fetch(
            `${URL}/cliente/${clienteId}`
        );

    exibirResultado(await resposta.json());
}

async function buscarTotalGte(){

    const valor =
        document.getElementById("valorGte").value;

    const resposta =
        await fetch(
            `${URL}/total/gte?valor=${valor}`
        );

    exibirResultado(await resposta.json());
}

async function buscarTotalGte(){

    const valor =
        document.getElementById("valorGte").value;

    const resposta =
        await fetch(
            `${URL}/total/gte?valor=${valor}`
        );

    exibirResultado(await resposta.json());
}

async function buscarDataStatus(){

    const data =
        document.getElementById("dataAnd").value;

    const status =
        document.getElementById("statusAnd").value;

    const resposta =
        await fetch(
            `${URL}/data-status?data=${data}&status=${status}`
        );

    exibirResultado(await resposta.json());
}

async function buscarDataStatus(){

    const data =
        document.getElementById("dataAnd").value;

    const status =
        document.getElementById("statusAnd").value;

    const resposta =
        await fetch(
            `${URL}/data-status?data=${data}&status=${status}`
        );

    exibirResultado(await resposta.json());
}

async function excluirPedido(){

    const id =
        document.getElementById("idExcluir").value;

    await fetch(`${URL}/${id}`,{
        method:"DELETE"
    });

    document.getElementById("resultado")
        .textContent =
        "Pedido removido com sucesso";
}