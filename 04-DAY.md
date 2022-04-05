# 04 Day
  - Creating the index page with some movies info
```javascript
<!DOCTYPE html>
<html lang="en">

<head>
  <title>Movie List</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <script>
    function load() {
      var apiUrl = 'http://localhost:8080/api/top250movies';
      var data = fetch(apiUrl).then(response => {
        return response.json();
      }).then(data => {
        data.length = 5;
        data.forEach(function (movie) {
          var table = document.getElementById("movieList").getElementsByTagName('tbody')[0];
          var newRow = table.insertRow(table.length);
          cell0 = newRow.insertCell(0);
          cell0.innerHTML = movie.title;

          cell1 = newRow.insertCell(1);
          cell1.innerHTML = movie.year;

          cell2 = newRow.insertCell(2);
          cell2.innerHTML = movie.crew;

          cell3 = newRow.insertCell(3);
          cell3.innerHTML = '<img src=" ' + movie.image + '">';
        });

      }).catch(err => {
        console.log('Erro', err);
      });

    }
  </script>
</head>

<body onload="load()">
  <div class="px-5 py-4 my-6">
    <table class="table" id="movieList">
      <thead class="thead-dark">
        <tr>
          <th>Movie</th>
          <th>Year</th>
          <th>Crew</th>
          <th>Poster</th>
        </tr>
      </thead>

      <tbody>

      </tbody>

    </table>
  </div>
</body>

</html>
```

![movie_image](https://i.postimg.cc/c4cz3tz7/Whats-App-Image-2022-04-03-at-2-45-13-PM.jpg)



