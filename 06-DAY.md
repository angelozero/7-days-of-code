# 05 Day
  - Creating the Marvel Api Request Service
  - I did exactly the same thing with this page ( using Movie List Page as an example )
  - I'm not really proud about the solution but again... bleh :P*

```javascript
function load() {
    var characterName = document.getElementById('nameField').value
    var apiUrl = 'http://localhost:8080/marvel/characters?name=' + characterName;
    var data = fetch(apiUrl).then(response => {
      return response.json();
    }).then(data => {

      // Cleaning the character list
      document.getElementById('characterList').getElementsByTagName('tbody')[0].innerHTML = '';

      data.forEach(function (character) {
        var table = document.getElementById("characterList").getElementsByTagName('tbody')[0];
        var newRow = table.insertRow(table.length);

        cell0 = newRow.insertCell(0);
        cell0.innerHTML = character.name;

        cell1 = newRow.insertCell(1);
        cell1.innerHTML = character.description;

        cell3 = newRow.insertCell(2);
        cell3.innerHTML = '<img src="' + character.image + '" class="img-thumbnail" width="104" height="36">';
      });


    }).catch(err => {
      console.log('Erro', err);
    });
  }

  document.addEventListener('keypress', function (e) {
    if (e.keyCode === 13 || e.which === 13) {
      e.preventDefault();
      load();
    }
  });
```
---
- The pagination
![movie_image](https://i.postimg.cc/BbTBdYxb/Whats-App-Image-2022-04-05-at-11-28-52-PM.jpg)



