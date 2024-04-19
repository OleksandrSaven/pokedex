package com.example.pokedexapp.data.mapper

import com.example.pokedexapp.domain.model.dto.PokemonInfoDto
import com.example.pokedexapp.domain.model.PokemonInfo
import com.example.pokedexapp.domain.model.PokemonNameUrl
import com.example.pokedexapp.domain.model.Stat
import com.example.pokedexapp.domain.model.Type
import com.example.pokedexapp.domain.model.Types
import com.example.pokedexapp.domain.model.dto.BaseStat
import com.example.pokedexapp.domain.model.entity.PokemonEntity
import com.example.pokedexapp.domain.model.entity.PokemonPages

fun PokemonInfoDto.toModel(): PokemonInfo {
    val id = id
    val name = name
    val height = height
    val weight = weight
    val baseExperience = baseExperience
    val type = types
    val status = stats
    return PokemonInfo(id, name, height, weight, baseExperience, type, status)
}

fun PokemonInfo.toEntity(): PokemonEntity {
    val id = id
    val name = name
    val height = height
    val weight = weight
    val baseExperience = baseExperience
    val hp = baseStatus[0].baseStat
    val atk = baseStatus[1].baseStat
    val def = baseStatus[2].baseStat
    val spa = baseStatus[3].baseStat
    val spd = baseStatus[4].baseStat
    val speed  = baseStatus[5].baseStat

    return PokemonEntity(id, name, height, weight, baseExperience, hp, atk,def, spa, spd, speed)
}

fun PokemonEntity.toPokemonInfo(): PokemonInfo {
    val id = id
    val name = name
    val height = height
    val weight = weight
    val baseExperience = baseExperience
    val types = emptyList<Types>()
    val hp = BaseStat(hp, Stat("hp"))
    val atk = BaseStat(atk, Stat("attack"))
    val def = BaseStat(def, Stat("defense"))
    val spa = BaseStat(spa, Stat("special-attack"))
    val spd = BaseStat(spd, Stat("special-defense"))
    val speed = BaseStat(speed, Stat("speed"))

    val baseStat = listOf(hp, atk, def, spa, spd, speed)
    return PokemonInfo(id, name, height, weight, baseExperience, types, baseStat)
}

fun PokemonNameUrl.toPage(): PokemonPages {
    return PokemonPages(name = name, url= url)
}

fun PokemonPages.toPokemonNameUrl(): PokemonNameUrl {
    return PokemonNameUrl(name = name, url = url)
}
