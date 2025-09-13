<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Calculadora Avanzada</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;800&display=swap" rel="stylesheet">
    <style>
        :root{
            --bg:#0f172a;
            --card:rgba(30,41,59,.85);
            --stroke:rgba(148,163,184,.3);
            --text:#e2e8f0;
            --muted:#cbd5e1;
            --accent1:#7c3aed;
            --accent2:#06b6d4;
            --active:#7c3aed;
        }
        *{font-family:Inter,system-ui,-apple-system,Segoe UI,Roboto,Ubuntu,Cantarell,Noto Sans,sans-serif;}
        body {
            min-height:100vh;
            background:
                    radial-gradient(60vw 60vh at 10% 10%, rgba(124,58,237,.2), transparent 50%),
                    radial-gradient(60vw 60vh at 90% 20%, rgba(6,182,212,.2), transparent 50%),
                    var(--bg);
            color: var(--text);
        }
        .card {
            background: var(--card);
            border: 1px solid var(--stroke);
            box-shadow: 0 10px 30px rgba(0,0,0,.35);
            backdrop-filter: blur(10px);
            border-radius: 22px;
        }
        .title-grad{
            color: #ffffff !important;
            font-weight: 800;
            letter-spacing: .3px;
        }
        .form-control, .form-select {
            background: #1e293b;
            color: #f8fafc !important;
            border-color: #293241;
            transition: border-color 0.2s, box-shadow 0.2s;
        }
        .form-control::placeholder { color: #cbd5e1 !important; opacity: 0.7; }
        .form-control:focus, .form-select:focus {
            box-shadow: 0 0 0 .2rem rgba(124,58,237,.25);
            border-color: var(--accent1);
        }
        .form-control.active, .form-select.active {
            border-color: var(--active);
            box-shadow: 0 0 0 .2rem rgba(124,58,237,.45);
        }
        .btn-primary{
            border: none;
            font-weight: 700;
            background: linear-gradient(90deg, var(--accent1), var(--accent2));
            color: #ffffff !important;
            transition: transform .15s ease, filter .2s ease;
        }
        .btn-primary:hover{ transform: translateY(-1px); filter: brightness(1.05); }
        .hint{ color: var(--muted); font-size:.9rem; }
        label, option, button, h1,h2,h3,h4,h5,h6,p,span { color: #ffffff !important; }
        select option { color: #000 !important; background-color: #1e293b; }
    </style>
</head>
<body>
<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-lg-8">

            <!-- Calculadora -->
            <div class="card p-4 p-md-5 mb-4">
                <div class="d-flex align-items-center justify-content-between mb-3">
                    <h1 class="h3 m-0 title-grad">Calculadora Avanzada</h1>
                </div>
                <p class="hint mb-4">Aritmética, trigonometría y conversiones de temperatura.</p>

                <form action="calc" method="post" id="calcForm">
                    <div class="row g-3 mb-3">
                        <div class="col-md-6">
                            <label class="form-label">Categoría</label>
                            <select class="form-select" name="category" id="category" required>
                                <option value="arit">Aritmética</option>
                                <option value="trig">Trigonometría</option>
                                <option value="temp">Temperatura</option>
                            </select>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label">Operación</label>
                            <select class="form-select" name="operation" id="operation" required></select>
                        </div>
                    </div>

                    <!-- Inputs aritmética -->
                    <div id="aritInputs" class="row g-3 mb-3">
                        <div class="col-md-6"><label class="form-label">Primer número</label><input type="text" class="form-control" name="a" placeholder="Ej. 12.5"></div>
                        <div class="col-md-6"><label class="form-label">Segundo número</label><input type="text" class="form-control" name="b" placeholder="Ej. 4"></div>
                    </div>

                    <!-- Inputs trigonometría -->
                    <div id="trigInputs" class="row g-3 mb-3" style="display:none;">
                        <div class="col-md-8"><label class="form-label">Valor</label><input type="text" class="form-control" name="a" placeholder="Ej. 45"></div>
                        <div class="col-md-4"><label class="form-label">Modo</label>
                            <select class="form-select" name="angleMode">
                                <option value="degrees" selected>Grados</option>
                                <option value="radians">Radianes</option>
                            </select>
                        </div>
                    </div>

                    <!-- Inputs temperatura -->
                    <div id="tempInputs" class="row g-3 mb-3" style="display:none;">
                        <div class="col-12"><label class="form-label">Valor de temperatura</label><input type="text" class="form-control" name="tvalue" placeholder="Ej. 100"></div>
                    </div>

                    <div class="d-grid"><button type="submit" class="btn btn-primary btn-lg rounded-4">Calcular</button></div>
                </form>
            </div>

        </div>
    </div>
</div>

<script>
    document.addEventListener('DOMContentLoaded', () => {
        const ops = {
            arit: [
                {v:'suma', t:'Suma'},
                {v:'resta', t:'Resta'},
                {v:'multi', t:'Multiplicación'},
                {v:'div', t:'División'}
            ],
            trig: [
                {v:'sin', t:'Seno'},
                {v:'cos', t:'Coseno'},
                {v:'tan', t:'Tangente'},
                {v:'cot', t:'Cotangente'}
            ],
            temp: [
                {v:'c2f', t:'Celsius → Fahrenheit'},
                {v:'f2c', t:'Fahrenheit → Celsius'},
                {v:'c2k', t:'Celsius → Kelvin'},
                {v:'k2c', t:'Kelvin → Celsius'}
            ]
        };

        const category = document.getElementById('category');
        const operation = document.getElementById('operation');

        function clearInputs() {
            document.querySelectorAll('#aritInputs input, #trigInputs input, #tempInputs input').forEach(inp => inp.value='');
        }

        function populateOps(cat){
            operation.innerHTML = '';
            ops[cat].forEach(o => {
                const opt = document.createElement('option');
                opt.value = o.v;
                opt.textContent = o.t;
                operation.appendChild(opt);
            });

            document.getElementById('aritInputs').style.display = (cat==='arit') ? 'block' : 'none';
            document.getElementById('trigInputs').style.display = (cat==='trig') ? 'block' : 'none';
            document.getElementById('tempInputs').style.display = (cat==='temp') ? 'block' : 'none';

            clearInputs();
        }

        populateOps(category.value);
        category.addEventListener('change', e => populateOps(e.target.value));

        document.querySelectorAll('input, select').forEach(el => {
            el.addEventListener('focus', e => e.target.classList.add('active'));
            el.addEventListener('blur', e => e.target.classList.remove('active'));
        });
    });
</script>
</body>
</html>