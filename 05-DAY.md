# 05 Day
  - Creating the pagination method 
  - I'm not really proud about the solution but in my defense I can say... *I don't fully understand how the frontend works and I don't like to code in JS to! So I gave my best and it's working! :)*

```javascript
function load() {

    var apiUrl = 'http://localhost:8080/api/top250movies';
    var data = fetch(apiUrl).then(response => {
      return response.json();
    }).then(data => {

      // Cleaning the movie list
      document.getElementById('movieList').getElementsByTagName('tbody')[0].innerHTML = '';

      // Get the movies by range
      var moviesByRange = getMoviesByRange(data);

      // Updating the select drop component
      var dropList = document.getElementById("selectDropList");
      if (dropList.options.length == 0) {
        for (var i = 0; i < moviesByRange.length; i++) {
          dropList.options[dropList.options.length] = new Option(i + 1, i);
        }
      }

      // Geting the movies by range
      var movieListRangePosition = getDropListPageValue() - 1;


      // Creating the rows
      moviesByRange[movieListRangePosition].forEach(function (movie) {
        var table = document.getElementById("movieList").getElementsByTagName('tbody')[0];
        var newRow = table.insertRow(table.length);

        cell0 = newRow.insertCell(0);
        cell0.innerHTML = movie.title;

        cell1 = newRow.insertCell(1);
        cell1.innerHTML = movie.year; 

        cell2 = newRow.insertCell(2);
        cell2.innerHTML = movie.crew;

        cell3 = newRow.insertCell(3);
        cell3.innerHTML = '<img src="' + movie.image + '" class="img-thumbnail" width="104" height="36">';
      });


    }).catch(err => {
      console.log('Erro', err);
    });
  }

  function getMoviesByRange(data) {
    var moviesPerPage = 10;
    return data.reduce((resultArray, item, index) => {
      const chunkIndex = Math.floor(index / moviesPerPage)
      if (!resultArray[chunkIndex]) {
        resultArray[chunkIndex] = [];
      }
      resultArray[chunkIndex].push(item);
      return resultArray;
    }, []);
  }

  function getDropListPageValue() {
    var element = document.getElementById("selectDropList");
    return element.options[element.selectedIndex].text;
  }
```

![movie_image](https://i.postimg.cc/NFfHDR9m/Whats-App-Image-2022-04-04-at-10-48-41-PM.jpg)



