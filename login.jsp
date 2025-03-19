<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <div class="col-md-4 offset-md-4">
            <h2>Login</h2>
            <form action="login" method="post">
                <div class="form-group">
                    <label>Username:</label>
                    <input type="text" name="username" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Password:</label>
                    <input type="password" name="password" class="form-control" required>
                </div>
                <button type="submit" class="btn btn-primary">Login</button>
            </form>
            <div class="text-danger mt-3">
                <%= request.getParameter("error") != null ? request.getParameter("error") : "" %>
            </div>
        </div>
    </div>
</body>
</html>
