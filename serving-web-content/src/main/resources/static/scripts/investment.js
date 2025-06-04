document.addEventListener("DOMContentLoaded", () => {
    const fetchButton = document.getElementById("fetch_price");

    if (fetchButton) {
        fetchButton.addEventListener("click", () => {
            const url = document.getElementById("amazon_url").value;

            console.log("Amazon URL submitted:", url);

            fetchPriceFromBackend(url);
        });
    } else {
        console.warn("fetch_price button not found on page.");
    }
});

function fetchPriceFromBackend(url) {
    fetch('http://127.0.0.1:5000/scrape_price', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ url: url })
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Price fetch failed');
        }
        return response.json();
    })
    .then(data => {
        console.log('Price received:', data);
        if (data.price) {
            renderInvestmentGraph(data.price);
        } else {
            alert('Error: ' + (data.error || 'Unknown error'));
        }
    })
    .catch(err => {
        console.error('Error fetching price:', err);
        alert('Failed to fetch price. Is the backend running?');
    });
}

function renderInvestmentGraph(initialPrice) {
    const modal = document.getElementById("graph_modal");
    modal.style.display = "block";

    const ctx = document.getElementById("investmentChart").getContext("2d");

    const years = Array.from({ length: 21 }, (_, i) => i);
    const balances = years.map(year => initialPrice * Math.pow(1 + 0.07, year));

    const finalValue = balances[balances.length - 1];
    const roiPercent = ((finalValue - initialPrice) / initialPrice) * 100;

    //Clear 
    if (window.investmentChartInstance) {
        window.investmentChartInstance.destroy();
    }

    //Create chart
    window.investmentChartInstance = new Chart(ctx, {
        type: 'line',
        data: {
            labels: years,
            datasets: [{
                label: 'Investment Value ($)',
                data: balances,
                borderColor: 'blue',
                backgroundColor: 'rgba(0, 0, 255, 0.1)',
                fill: true,
                tension: 0.2
            }]
        },
        options: {
            responsive: true,
            plugins: {
                title: {
                    display: true,
                    text: `Investment Growth (Initial $${initialPrice.toFixed(2)})`
                }
            },
            scales: {
                y: {
                    beginAtZero: false,
                    title: {
                        display: true,
                        text: 'Value ($)'
                    }
                },
                x: {
                    title: {
                        display: true,
                        text: 'Years'
                    }
                }
            }
        }
    });

    //summary 
    const modalElement = document.getElementById("graph_modal");

    //summary box
    let summaryContainer = document.getElementById("investment_summary");

    if (!summaryContainer) {
        summaryContainer = document.createElement("div");
        summaryContainer.id = "investment_summary";
        summaryContainer.style.position = "absolute";
        summaryContainer.style.top = "50px";
        summaryContainer.style.right = "50px";
        summaryContainer.style.backgroundColor = "#fff";
        summaryContainer.style.padding = "12px 18px";
        summaryContainer.style.border = "1px solid #ccc";
        summaryContainer.style.borderRadius = "8px";
        summaryContainer.style.boxShadow = "0 2px 8px rgba(0,0,0,0.1)";
        summaryContainer.style.fontSize = "16px";
        summaryContainer.style.color = "#333";
        summaryContainer.style.fontWeight = "bold";
        summaryContainer.style.zIndex = "1000";

        modalElement.appendChild(summaryContainer);
    }

    summaryContainer.innerHTML = `
        Final Value after 20 years: $${finalValue.toFixed(2)}<br>
        ROI: ${roiPercent.toFixed(2)}%
    `;
}

//close button
document.addEventListener("DOMContentLoaded", () => {
    const closeModal = document.getElementById("close_modal");
    const modal = document.getElementById("graph_modal");

    if (closeModal && modal) {
        closeModal.addEventListener("click", () => {
            modal.style.display = "none";
        });

 
        window.addEventListener("click", (event) => {
            if (event.target === modal) {
                modal.style.display = "none";
            }
        });
    }
});

