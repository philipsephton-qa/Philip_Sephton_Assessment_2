`use strict`;
const POKEDEX = document.querySelector(`#pokedex`).value;
const NAME = document.querySelector(`#pokemonName`).value;
const ATTACK = document.querySelector(`#pokemonAtt`).value;
const DEFENCE = document.querySelector(`#pokemonDef`).value;
const SPEED = document.querySelector(`#pokemonSpd`).value;
const PRIMARYTYPE = document.querySelector(`#pokemonPrimaryType`).value;
const SECONDARYTYPE = document.querySelector(`#pokemonSecondaryType`).value;
const PRIMARYWEAKNESS = document.querySelector(`#pokemonPrimaryWeakness`).value;
const SECONDARYWEAKNESS = document.querySelector(`#pokemonSecondaryWeakness`).value;
const EVOLVES = document.querySelector(`#evolves`).value;
const DATABANK = document.querySelector(`#dataBank`);
const ALERT = document.querySelector(`#alertResponse`);

// axios
//     .get("")
//     .then((response)=>{
//         for(let data of response.data){
//             printToScreen(data)
//         }
//     })
//     .catch((error)=> console.error(error));

const printToScreen = (information) =>{
    const p = document.createElement("p");
    const pokemon = document.createTextNode(`Pokedex Number: ${POKEDEX}, Pokemon Name: ${NAME}, Pokemon Attack: ${ATTACK}, Pokemon Defence: ${DEFENCE}, Pokemon Speed: ${SPEED} Pokemon Type: ${PRIMARYTYPE} ${SECONDARYTYPE}, Pokemon Weakness: ${PRIMARYWEAKNESS} ${SECONDARYWEAKNESS}, Evolves: ${EVOLVES}`)
    p.appendChild(pokemon);
    DATABANK.appendChild(p);
}

const createPokemon = () =>{
    const POKEDEX_VALUE = POKEDEX.value;
    const NAME_VALUE = NAME.value;
    const ATTACK_VALUE = ATTACK.value;
    const DEFENCE_VALUE = DEFENCE.value;
    const SPEED_VALUE = SPEED.value;
    const PRIMARYTYPE_VALUE = PRIMARYTYPE.value;
    const SECONDARYTYPE_VALUE = SECONDARYTYPE.value;
    const PRIMARYWEAKNESS_VALUE = PRIMARYWEAKNESS.value;
    const SECONDARYWEAKNESS_VALUE = SECONDARYWEAKNESS.value;
    const EVOLVES_VALUE = EVOLVES.value;

    let object = {
        pokedex : POKEDEX_VALUE,
        name : NAME_VALUE,
        attack : ATTACK_VALUE,
        defence : DEFENCE_VALUE,
        speed : SPEED_VALUE,
        primaryType : PRIMARYTYPE_VALUE,
        secondaryType : SECONDARYTYPE_VALUE,
        primaryWeakness : PRIMARYWEAKNESS_VALUE,
        secondaryWeakness : SECONDARYWEAKNESS_VALUE,
        evolves : EVOLVES_VALUE
    }
    axios
        .post("", object)
        .then( (response) => {
            ALERT.setAttribute("class", "alert alert-success");
            ALERT.innerHTML = "Pokemon has been created";
            setTimeout( () => {
                ALERT.removeAttribute("class");
                ALERT.innerHTML = ""
            },1000)
        })
        .catch( (error) => console.error(error));
}