`use strict`;
const POKEDEX = document.querySelector(`#pokedex`);
const NAME = document.querySelector(`#pokemonName`);
const ATTACK = document.querySelector(`#pokemonAtt`);
const DEFENCE = document.querySelector(`#pokemonDef`);
const SPEED = document.querySelector(`#pokemonSpd`);
const PRIMARYTYPE = document.querySelector(`#pokemonPrimaryType`);
const SECONDARYTYPE = document.querySelector(`#pokemonSecondaryType`);
const PRIMARYWEAKNESS = document.querySelector(`#pokemonPrimaryWeakness`);
const SECONDARYWEAKNESS = document.querySelector(`#pokemonSecondaryWeakness`);
const EVOLVES = document.querySelector(`#evolves`);
const POKEDEXUP = document.querySelector(`#pokedexUp`);
const NAMEUP = document.querySelector(`#pokemonNameUp`);
const ATTACKUP = document.querySelector(`#pokemonAttUp`);
const DEFENCEUP = document.querySelector(`#pokemonDefUp`);
const SPEEDUP = document.querySelector(`#pokemonSpdUp`);
const PRIMARYTYPEUP = document.querySelector(`#pokemonPrimaryTypeUp`);
const SECONDARYTYPEUP = document.querySelector(`#pokemonSecondaryTypeUp`);
const PRIMARYWEAKNESSUP = document.querySelector(`#pokemonPrimaryWeaknessUp`);
const SECONDARYWEAKNESSUP = document.querySelector(`#pokemonSecondaryWeaknessUp`);
const EVOLVESUP = document.querySelector(`#evolvesUp`);
const DATABANK = document.querySelector(`#dataBank`);
const ALERT = document.querySelector(`#alertResponse`);


const initialise = () =>{
axios.get("http://localhost:8080/getAll")
    .then((response)=>{
        for(let abc of response.data){
            printToScreen(abc);
        }
    })
    .catch((error)=> console.error(error));
}

const printToScreen = (information) =>{
    const br = document.createElement("br")
    const p = document.createElement("tr");
    const td1 = document.createElement("td");
    const td2 = document.createElement("td");
    const td3 = document.createElement("td");
    const td4 = document.createElement("td");
    const pokemon1 = document.createTextNode(`Pokedex Number: ${POKEDEX.value}, Name: ${NAME.value}, Evolves: ${EVOLVES.value}`)
    const pokemon2 = document.createTextNode(`Attack: ${ATTACK.value}, Defence: ${DEFENCE.value}, Speed: ${SPEED.value}`)
    const pokemon3 = document.createTextNode(`Type: ${PRIMARYTYPE.value} ${SECONDARYTYPE.value}, Weakness: ${PRIMARYWEAKNESS.value} ${SECONDARYWEAKNESS.value}`)
    
    const upBtn = document.createElement('button');
    upBtn.innerHTML = `Update`
    upBtn.setAttribute("class", "btn btn-warning");
    upBtn.setAttribute("onclick", "updatePokemonBox();");

    const rmBtn = document.createElement('button');
    rmBtn.innerHTML = `Remove`
    rmBtn.setAttribute("class", "btn btn-danger");
    rmBtn.setAttribute("onclick", "removePokemon();");
    
    td1.appendChild(pokemon1);
    td2.appendChild(pokemon2);
    td3.appendChild(pokemon3);
    td4.appendChild(upBtn);
    td4.appendChild(rmBtn);
    p.appendChild(td1);
    p.appendChild(td2);
    p.appendChild(td3);
    p.appendChild(td4);
    p.appendChild(br);
    DATABANK.appendChild(p);
    console.log(p)
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

    let obj = {
        pokeDex : POKEDEX_VALUE,
        name : NAME_VALUE,
        attack : ATTACK_VALUE,
        defence : DEFENCE_VALUE,
        speed : SPEED_VALUE,
        type1 : PRIMARYTYPE_VALUE,
        type2 : SECONDARYTYPE_VALUE,
        weakness1 : PRIMARYWEAKNESS_VALUE,
        weakness2 : SECONDARYWEAKNESS_VALUE,
        evolves : EVOLVES_VALUE
    }
    axios
        .post("http://localhost:8080/create", obj)
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

const updatePokemon = () =>{
    const id = 1;
    const POKEDEX_VALUE = POKEDEXUP.value
    const NAME_VALUE = NAMEUP.value;
    const ATTACK_VALUE = ATTACKUP.value;
    const DEFENCE_VALUE = DEFENCEUP.value;
    const SPEED_VALUE = SPEEDUP.value;
    const PRIMARYTYPE_VALUE = PRIMARYTYPEUP.value;
    const SECONDARYTYPE_VALUE = SECONDARYTYPEUP.value;
    const PRIMARYWEAKNESS_VALUE = PRIMARYWEAKNESSUP.value;
    const SECONDARYWEAKNESS_VALUE = SECONDARYWEAKNESSUP.value;
    const EVOLVES_VALUE = EVOLVESUP.value;

    let obj = {
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
        .put("http://localhost:8080/update/"+id, obj)
        .then( (response) => {
            ALERT.setAttribute("class", "alert alert-success");
            ALERT.innerHTML = "Pokemon has been updated";
            setTimeout( () => {
                ALERT.removeAttribute("class");
                ALERT.innerHTML = ""
            },1000)
        })
        .catch( (error) => console.error(error));
}

const closeInput = () => {
    document.getElementById(`update-box`).style.display = `none`;
}
const updatePokemonBox = () => {
    document.getElementById(`update-box`).style.display = `block`
}

const removePokemon = () => {

    
}