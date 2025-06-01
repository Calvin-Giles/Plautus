
        const goalTable = document.querySelector("#goalTable tbody");

        function addGoal(event) {
            event.preventDefault();
            const name = document.getElementById("goalName").value;
            const target = parseFloat(document.getElementById("targetAmount").value);
            const date = document.getElementById("targetDate").value;
            const saved = parseFloat(document.getElementById("currentSavings").value);
            const type = document.getElementById("goalType").value;

            const progress = Math.min((saved / target) * 100, 100).toFixed(1);

            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${name}</td>
                <td>${type}</td>
                <td>$${target.toFixed(2)}</td>
                <td>$${saved.toFixed(2)}</td>
                <td>${date}</td>
                <td><progress value="${progress}" max="100"></progress> ${progress}%</td>
                <td><button onclick="this.closest('tr').remove()">Delete</button></td>
            `;
            goalTable.appendChild(row);
        }
    