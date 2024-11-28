# Parcial Mutantes Desarrollo

Este parcial corresponde al parcial de back end de desarrollo de software de la UTN

Proyecto creado en:
* java con SpringBoot
+ Base de datos H2
+ Deployado en render
#### Podemos consultar si un `adn`es o no `mutante` haciendo un POST en postman al siguiente link:

nota: si ya existe un adn en nuestra base de datos este no se vuelve a contar

+ https://parcialmutantesspringboot.onrender.com/mutant

+ configuracion en postman


ejemplos de cadenas de adn humanas
```JSON
{
"dna": [
"GTGCG",
"CAGTG",
"TTATG",
"AGAAG",
"CTCCT"
]
}
```
ejemplos de cadenas de adn mutantes
```json
{
"dna": [
"GTGCG",
"CAGTG",
"TTATG",
"AGAAG",
"CTCCG"
]
}
```

#### podemos obtener los `stats` de `adn` de las siguientes maneras

+ ingresando un `GET` en `Postman` a la siguiente url:

https://parcialmutantesspringboot.onrender.com/stats

+ Utilizando `curl` en `linux`

```bash
curl -X GET https://parcialmutantesspringboot.onrender.com/stats
```

#### Ejemplos en postman
![imagen](https://github.com/user-attachments/assets/4e37ad05-2e3f-4dcd-b179-f3d56255431f)

![imagen](https://github.com/user-attachments/assets/afffd2c1-505d-4959-9621-0c35ee3b0b74)

#### Ejemplos en curl
![Pasted image 20241128032526](https://github.com/user-attachments/assets/6c448ff5-ec48-4195-a23f-ef62c866b63b)

