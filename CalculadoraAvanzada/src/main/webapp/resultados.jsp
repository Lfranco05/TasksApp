<%--
  Created by IntelliJ IDEA.
  User: luisa
  Date: 23/08/2025
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!doctype html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Resultados</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;800&display=swap" rel="stylesheet">
  <style>
    :root {
      --bg: #0f172a;
      --card: rgba(30, 41, 59, 0.85);
      --stroke: rgba(148, 163, 184, 0.3);
      --text: #e2e8f0;
      --muted: #cbd5e1;
      --accent1: #7c3aed;
      --accent2: #06b6d4;
      --active: #7c3aed;
      --input-bg: #1e293b;
      --input-text: #f8fafc;
    }

    * { font-family: Inter, system-ui, -apple-system, "Segoe UI", Roboto, Ubuntu, Cantarell, "Noto Sans", sans-serif; }

    body {
      min-height: 100vh;
      background:
              radial-gradient(60vw 60vh at 10% 10%, rgba(124, 58, 237, .2), transparent 50%),
              radial-gradient(60vw 60vh at 90% 20%, rgba(6, 182, 212, .2), transparent 50%),
              var(--bg);
      color: var(--text);
    }

    .card {
      background: var(--card);
      border: 1px solid var(--stroke);
      box-shadow: 0 10px 30px rgba(0,0,0,.35);
      backdrop-filter: blur(10px);
      border-radius: 22px;
      color: var(--text);
      opacity: 0;
      transform: translateY(20px);
      animation: fadeInUp 0.6s forwards;
    }

    .title-grad {
      background: linear-gradient(90deg, var(--accent1), var(--accent2));
      -webkit-background-clip: text;
      background-clip: text;
      color: transparent;
      font-weight: 800;
      letter-spacing: .3px;
    }

    .table { color: var(--text); }
    .table > :not(caption) > * > * {
      background-color: transparent;
      border-bottom-color: var(--stroke);
      color: var(--text);
    }

    .btn-outline-light {
      border-color: var(--stroke);
      color: var(--text);
      transition: all 0.3s ease;
    }

    .btn-outline-light:hover {
      background: linear-gradient(90deg, var(--accent1), var(--accent2));
      color: white;
      border-color: transparent;
    }

    .muted { color: var(--muted); }

    /* Animación fade-in desde abajo */
    @keyframes fadeInUp {
      to { opacity: 1; transform: translateY(0); }
    }
  </style>
</head>
<body>
<div class="container py-5">
  <div class="row justify-content-center">
    <div class="col-lg-8">

      <!-- Resultado -->
      <div class="card p-4 p-md-5 mb-4">
        <div class="d-flex align-items-center justify-content-between mb-3">
          <h1 class="h4 m-0 title-grad">Resultado</h1>
          <span class="badge rounded-pill" style="background:rgba(6,182,212,.15); border:1px solid rgba(6,182,212,.35); color:#99f6e4">Historial en memoria</span>
        </div>

        <c:if test="${not empty error}">
          <div class="alert alert-danger" role="alert">${error}</div>
        </c:if>

        <c:if test="${empty error}">
          <p class="mb-1 muted">Operación:</p>
          <h2 class="h5">${description}</h2>
          <p class="mb-0 muted">Valor:</p>
          <h2 class="display-6">${result}</h2>
        </c:if>

        <div class="mt-4 d-flex gap-2">
          <a class="btn btn-outline-light rounded-4" href="index.jsp">Nueva operación</a>
        </div>
      </div>

      <!-- Historial -->
      <div class="card p-4 p-md-5">
        <h2 class="h5 mb-3">Historial reciente</h2>
        <c:choose>
          <c:when test="${empty history}">
            <p class="muted">Sin operaciones aún.</p>
          </c:when>
          <c:otherwise>
            <div class="table-responsive">
              <table class="table align-middle">
                <thead>
                <tr>
                  <th class="muted">Fecha/Hora</th>
                  <th class="muted">Descripción</th>
                  <th class="muted">Resultado</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="h" items="${history}">
                  <tr>
                    <td>${h.when}</td>
                    <td>${h.description}</td>
                    <td>${h.result}</td>
                  </tr>
                </c:forEach>
                </tbody>
              </table>
            </div>
          </c:otherwise>
        </c:choose>
      </div>

    </div>
  </div>
</div>
</body>
</html>