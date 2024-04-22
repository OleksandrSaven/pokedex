package com.example.pokedexapp.data.mapper

import com.example.pokedexapp.data.constant.PokemonStrings
import com.example.pokedexapp.domain.model.dto.PokemonInfoDto
import com.example.pokedexapp.domain.model.PokemonInfo
import com.example.pokedexapp.domain.model.PokemonNameUrl
import com.example.pokedexapp.domain.model.Stat
import com.example.pokedexapp.domain.model.Type
import com.example.pokedexapp.domain.model.Types
import com.example.pokedexapp.domain.model.dto.BaseStat
import com.example.pokedexapp.domain.model.entity.PokemonEntity
import com.example.pokedexapp.domain.model.entity.PokemonPages

const val DEFAULT_VALUE = "Default value"

const val HP_INDEX = 0
const val ATK_INDEX = 1
const val DEF_INDEX = 2
const val SPA_INDEX = 3
const val SPD_INDEX = 4
const val SPEED_INDEX = 5
const val SLOT1_INDEX = 0
const val SLOT2_INDEX = 1
const val TYPE1 = 1
const val TYPE2 = 2

fun PokemonInfoDto.toModel(): PokemonInfo {
    val id = id
    val name = name
    val height = height
    val weight = weight
    val baseExperience = baseExperience
    val type = types
    val status = stats
    return PokemonInfo(
        id = id,
        name = name,
        height = height,
        weight = weight,
        baseExperience = baseExperience,
        types = type,
        baseStatus = status)
}

fun PokemonInfo.toEntity(): PokemonEntity {
    val id = id
    val name = name
    val height = height
    val weight = weight
    val baseExperience = baseExperience
    val hp = baseStatus[HP_INDEX].baseStat
    val atk = baseStatus[ATK_INDEX].baseStat
    val def = baseStatus[DEF_INDEX].baseStat
    val spa = baseStatus[SPA_INDEX].baseStat
    val spd = baseStatus[SPD_INDEX].baseStat
    val speed  = baseStatus[SPEED_INDEX].baseStat
    val slot1 = types[SLOT1_INDEX].type.name
    val slot2 = types.getOrNull(SLOT2_INDEX)?.type?.name ?: DEFAULT_VALUE
    return PokemonEntity(
        id = id,
        name = name,
        height = height,
        weight = weight,
        baseExperience = baseExperience,
        hp = hp,
        atk = atk,
        def = def,
        spa = spa,
        spd = spd,
        speed = speed,
        slot1 = slot1,
        slot2 = slot2
    ) }

fun PokemonEntity.toPokemonInfo(): PokemonInfo {
    val id = id
    val name = name
    val height = height
    val weight = weight
    val baseExperience = baseExperience
    val slot1 = Types(TYPE1, Type(slot1))
    val slot2 = Types(TYPE2, Type(slot2))
    val types = listOf(slot1, slot2)
    val hp = BaseStat(hp, Stat(PokemonStrings.HP))
    val atk = BaseStat(atk, Stat(PokemonStrings.ATTACK))
    val def = BaseStat(def, Stat(PokemonStrings.DEFENSE))
    val spa = BaseStat(spa, Stat(PokemonStrings.SPECIAL_ATTACK))
    val spd = BaseStat(spd, Stat(PokemonStrings.SPECIAL_DEFENSE))
    val speed = BaseStat(speed, Stat(PokemonStrings.SPEED))
    val baseStat = listOf(hp, atk, def, spa, spd, speed)
    return PokemonInfo(
        id = id,
        name = name,
        height = height, weight, baseExperience, types, baseStat)
}

fun PokemonNameUrl.toPage(): PokemonPages {
    return PokemonPages(name = name, url= url)
}

fun PokemonPages.toPokemonNameUrl(): PokemonNameUrl {
    return PokemonNameUrl(name = name, url = url)
}
