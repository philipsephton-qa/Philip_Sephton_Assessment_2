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
const config = { headers: { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': 'http://127.0.0.1:5500' } };
var id;


const initialise = () => {
    axios.get("http://localhost:8080/getAll", {
        "headers": {
            "Access-Control-Allow-Origin": "*"
        }
    })
        .then((response) => {
            for (let abc of response.data) {
                printToScreen(abc);
            }
        })
        .catch((error) => console.error(error));
}

const printToScreen = (information) => {
    const br = document.createElement("br")
    const p = document.createElement("tr");
    const td1 = document.createElement("td");
    const td2 = document.createElement("td");
    const td3 = document.createElement("td");
    const td4 = document.createElement("td");
    const pokemon1 = document.createTextNode(`Name: ${information.name}, Id: ${information.id}, Pokedex Number: ${information.pokeDex}, Evolves: ${information.evolves}`)
    const pokemon2 = document.createTextNode(`Attack: ${information.attack}, Defence: ${information.defence}, Speed: ${information.speed}`)
    const pokemon3 = document.createTextNode(`Type: ${information.type1} ${information.type2}, Weakness: ${information.weakness1} ${information.weakness2}`)

    const upBtn = document.createElement('button');
    upBtn.innerHTML = `Update`
    upBtn.setAttribute("class", "btn btn-warning");
    upBtn.setAttribute("id", "updateSubmitButton");
    upBtn.addEventListener("click", () => updatePokemonBox(information.id));

    const rmBtn = document.createElement("a");
    rmBtn.innerText = `Remove`;
    rmBtn.setAttribute("class", "btn btn-danger");
    rmBtn.setAttribute("id", "removePokemonButton")
    rmBtn.addEventListener("click", () => removePokemon(information.id));

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
}

const createPokemon = () => {
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
        pokeDex: POKEDEX_VALUE,
        name: NAME_VALUE,
        attack: ATTACK_VALUE,
        defence: DEFENCE_VALUE,
        speed: SPEED_VALUE,
        type1: PRIMARYTYPE_VALUE,
        type2: SECONDARYTYPE_VALUE,
        weakness1: PRIMARYWEAKNESS_VALUE,
        weakness2: SECONDARYWEAKNESS_VALUE,
        evolves: EVOLVES_VALUE
    }
    axios
        .post("http://localhost:8080/create", obj, {
            headers: { 'Access-Control-Allow-Origin': '*' }
        }).then((response) => {
            console.log(response);
        })
        .catch((error) => console.error(error));
    location.reload();
}

const updatePokemon = () => {
    const PID = parseInt(id);
    const POKEDEX_VALUE1 = POKEDEXUP.value
    const NAME_VALUE1 = NAMEUP.value;
    const ATTACK_VALUE1 = ATTACKUP.value;
    const DEFENCE_VALUE1 = DEFENCEUP.value;
    const SPEED_VALUE1 = SPEEDUP.value;
    const PRIMARYTYPE_VALUE1 = PRIMARYTYPEUP.value;
    const SECONDARYTYPE_VALUE1 = SECONDARYTYPEUP.value;
    const PRIMARYWEAKNESS_VALUE1 = PRIMARYWEAKNESSUP.value;
    const SECONDARYWEAKNESS_VALUE1 = SECONDARYWEAKNESSUP.value;
    const EVOLVES_VALUE1 = EVOLVESUP.value;

    let obj = {
        pokeDex: POKEDEX_VALUE1,
        name: NAME_VALUE1,
        attack: ATTACK_VALUE1,
        defence: DEFENCE_VALUE1,
        speed: SPEED_VALUE1,
        type1: PRIMARYTYPE_VALUE1,
        type2: SECONDARYTYPE_VALUE1,
        weakness1: PRIMARYWEAKNESS_VALUE1,
        weakness2: SECONDARYWEAKNESS_VALUE1,
        evolves: EVOLVES_VALUE1
    }
    axios
        .put("http://localhost:8080/update/" + PID, obj, {
            "headers": {
                "Access-Control-Allow-Origin": "*"
            }
        })
        .then((response) => {
            console.log(response);
            setTimeout(() => {
                ALERT.removeAttribute("class");
                ALERT.innerHTML = ""
            }, 1000)
        })
        .catch((error) => console.error(error));
    location.reload();
}

const closeInput = () => {
    document.getElementById(`update-box`).style.display = `none`;
}
const updatePokemonBox = (id) => {
    document.getElementById(`update-box`).style.display = `block`;
    this.id = id;
}

const removePokemon = (id) => {
    console.log(id);
    axios.delete("http://localhost:8080/remove/" + id, config)
        .then((response) => {
            ALERT.setAttribute("class", "alert alert-success");
            ALERT.innerHTML = "Pokemon has been Deleted";
            setTimeout(() => {
                ALERT.removeAttribute("class");
                ALERT.innerHTML = ""
            }, 1000)
        })
        .catch((error) => console.error(error));
    location.reload();


}