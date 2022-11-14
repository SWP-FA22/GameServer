document.addEventListener("DOMContentLoaded", () => {
    fetch("admin", {
        method: "post",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: "action=get-posts&approve=false"
    }).then(e => e.json()).then(e => {
        document.querySelector("#v-tabs-post > div > table > tbody").innerHTML = e.posts.map(e => {
            return `<tr>
                        <th scope="row">
                            <a href="view-post?id=${e.id}" class="nav-link text-danger">${e.title}</a>
                        </th>
                        <td>
                            <a href="profile?id=${e['player-id']}" class="nav-link text-warning">${e['player-name']}</a>
                        </td>
                        <td>
                            ${e.date}
                        </td>
                    </tr>`
        }).join("");
    });

    fetch("admin", {
        method: "post",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: "action=get-accounts&page=0&size=10"
    }).then(e => e.json()).then(e => {
        document.querySelector("#v-tabs-account > div > table > tbody").innerHTML = e.players.map(e => {
            return `<tr>
                        <th scope="row">
                            <a href="profile?id=${e.id}" class="nav-link text-warning">${e.username}</a>
                        </th>
                        <td>${e.name}</td>
                        <td>${e.email}</td>
                        <td>
                            ${e.role != -1 ? `<button class="btn btn-danger" onclick="banUser(this, ${e.id})">Ban</button>` : `<button class="btn btn-success" onclick="unbanUser(this, ${e.id})">UnBan</button>`}
                        </td>
                    </tr>`;
        }).join("");
    });

    fetch("admin", {
        method: "post",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: `action=get-transactions&page=0&size=10`
    }).then(e => e.json()).then(e => {
        document.querySelector("#v-tabs-transaction > div > table > tbody").innerHTML = e.transactions.map(e => {
            return `<tr>
                            <th scope="row">${e.time}</th>
                            <td>
                            <a href="profile?id=${e.playerID}" class="nav-link text-warning">${e.playerName}</a>
                            </td>
                            <td>${e.amount}</td>
                            </tr>`;
        }).join("");
    });
});

function banUser(btn, id) {
    //<button class="btn btn-danger" onclick="banUser(this, ${e.id})">Ban</button>
    fetch("admin", {
        method: "post",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: `action=ban-player&id=${id}`
    }).then(e => e.json()).then(e => {
        btn.parentNode.innerHTML = `<button class="btn btn-success" onclick="unbanUser(this, ${id})">UnBan</button>`;
    });
}

function unbanUser(btn, id) {
    //<button class="btn btn-danger" onclick="banUser(this, ${e.id})">Ban</button>
    fetch("admin", {
        method: "post",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: `action=ban-player&id=${id}`
    }).then(e => e.json()).then(e => {
        btn.parentNode.innerHTML = `<button class="btn btn-danger" onclick="banUser(this, ${id})">Ban</button>`;
    });
}

function searchAccounts(account) {
    const searchAccount = account.querySelector("#search-account").value;

    fetch("admin", {
        method: "post",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: `action=get-accounts&page=0&size=10&q=${searchAccount}`
    }).then(e => e.json()).then(e => {
        document.querySelector("#v-tabs-account > div > table > tbody").innerHTML = e.players.map(e => {
            return `<tr>
                        <th scope="row">
                            <a href="profile?id=${e.id}" class="nav-link text-warning">${e.username}</a>
                        </th>
                        <td>${e.name}</td>
                        <td>${e.email}</td>
                        <td>
                            ${e.role != -1 ? `<button class="btn btn-danger" onclick="banUser(this, ${e.id})">Ban</button>` : `<button class="btn btn-success" onclick="unbanUser(this, ${e.id})">UnBan</button>`}
                        </td>
                    </tr>`;
        }).join("");
    });
}

function searchTransactions(transaction) {
    const fromDate = transaction.querySelector("#from-date").value;
    const toDate = transaction.querySelector("#to-date").value;
    const searchAccount = transaction.querySelector("#search-account").value;

    fetch("admin", {
        method: "post",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: `action=get-transactions&page=0&size=10&from=${fromDate}&to=${toDate}&username=${searchAccount}`
    }).then(e => e.json()).then(e => {
        document.querySelector("#v-tabs-transaction > div > table > tbody").innerHTML = e.transactions.map(e => {
            return `<tr>
                            <th scope="row">${e.time}</th>
                            <td>
                            <a href="profile?id=${e.playerID}" class="nav-link text-warning">${e.playerName}</a>
                            </td>
                            <td>${e.amount}</td>
                            </tr>`;
        }).join("");
    });
}