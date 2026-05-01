async function carregarProdutos() {
    console.log("Tentando buscar produtos...");
    try {
        const resposta = await fetch('http://localhost:8080/api/produtos');
        
        if (!resposta.ok) {
            throw new Error(`Erro na requisição: ${resposta.status}`);
        }

        const produtos = await resposta.json();
        console.log("Produtos recebidos:", produtos);
        
        const corpoTabela = document.querySelector('table tbody');
        if (!corpoTabela) {
            // Se você não tiver a tag <tbody> no HTML, vamos usar a table direto
            console.error("Tag <tbody> não encontrada no seu HTML!");
            return;
        }

        corpoTabela.innerHTML = '';

        produtos.forEach(p => {
            const linha = document.createElement('tr');
            linha.innerHTML = `
                <td>${p.id}</td>
                <td>${p.nome}</td>
                <td>R$ ${p.preco.toFixed(2)}</td>
                <td>${p.quantidade}</td>
                <td>R$ ${(p.preco * p.quantidade).toFixed(2)}</td>
            `;
            corpoTabela.appendChild(linha);
        });

        const contador = document.getElementById('total-itens');
        if (contador) contador.innerText = produtos.length;

    } catch (erro) {
        console.error("Houve um problema ao conectar com o Java:", erro);
        alert("Não foi possível carregar os dados. Verifique se o IntelliJ está rodando!");
    }
}

carregarProdutos();