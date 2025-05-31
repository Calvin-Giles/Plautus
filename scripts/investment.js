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

    new Chart(ctx, {
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
}

// Handle close button
document.addEventListener("DOMContentLoaded", () => {
    const closeModal = document.getElementById("close_modal");
    const modal = document.getElementById("graph_modal");

    if (closeModal && modal) {
        closeModal.addEventListener("click", () => {
            modal.style.display = "none";
        });

        // Optional: Close modal when clicking outside content
        window.addEventListener("click", (event) => {
            if (event.target === modal) {
                modal.style.display = "none";
            }
        });
    }
});
