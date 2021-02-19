//63206383
//test
let div = document.createElement("div")
let heroes = ["anti-mage","axe","bane","bloodseeker","crystal maiden",
            "drow ranger","earthshaker","juggernaught","mirana",
            "morphling","shadow fiend","phantom lancer","puck","pudge",
            "razor","sand king","storm spirit","sven","tiny",
            "vengeful spirit","windranger","zeus","kunkka","BLANK","lina",
            "lich","lion","shadow shaman","slardar","tidehunter",
            "witch doctor","riki","enigma","tinker","sniper","necrophos",
            "warlock","beastmaster","queen of pain","venomancer",
            "faceless void","wraith king","death prophet",
            "phantom assassin","pugna","templar assassing",
            "viper","luna","dragon knight","dazzle","clockwerk",
            "leshrac","nature's prophet","lifestealer","dark seer",
            "clinkz","omniknight","enchantress","huskar","night stalker",
            "broodmother","bounty hunter","weaver","jakiro","batrider",
            "chen","specter","doom","ancient apparition","ursa",
            "spirit breaker","gyrocopter","alchemist","invoker","silencer",
            "outworld devourer","lycan","brewmaster","shadow demon",
            "lone druid","chaos knight","meepo","treant protector",
            "ogre magi","undying","rubick","disruptor","nyx assassin",
            "naga siren","keeper of the light","io","visage",
            "slark","medusa","troll warlord","centaur warrunner",
            "magnus","timbersaw","bristleback","tusk","skywrath mage",
            "abaddon","elder titan","legion commander","ember spirit",
            "earth spirit","abyssal underlord","terrorblade","phoenix",
            "techies","oracle","winter wyvern","Arc warden"]
const getProfileInfo = function(){

    let playerId = $("#accountId").val();

    $.get(
        
        
        `https://api.opendota.com/api/players/${playerId}`,
        function(data, textStatus , jqXHR ){
            $("#reportHeader").text(`Account Report for ${data.profile.personaname}`)
            $("#profileIcon").attr("src",data.profile.avatarfull)
            $("#profileInfo").text(`MMR Estiamte: ${data.mmr_estimate.estimate}, 
                                    Last login: ${data.profile.last_login},
                                    User since ${data.tracked_until}`)
            

            console.log( data )
            console.log( textStatus )
            console.log( jqXHR )
        }

        
    )

    for(let i=0;i<heroes.length;i++){
        console.log(i+" " + heroes[i])
    }
}

const getRecentGames = function(){

    let playerIdForMatch = $("#accountId").val();
    $("#recentMatches").text("");
    for(let i=0;i<20;i++){
        
        $.get(
            
            
            `https://api.opendota.com/api/players/${playerIdForMatch}/recentMatches`,
            function(data, textStatus, jqXHR){
            
            $("#recentMatches").append(document.createElement("div"))
            $("#recentMatches").append("Match " + (i+1) + " ")
            $("#recentMatches").append(`Match id: ${data[i].match_id} `)
            $("#recentMatches").append(`Match duration: ${data[i].duration} `)
            $("#recentMatches").append(`Hero : ` + heroes[data[i].hero_id-1])
            $("#recentMatches").append(`kills: ${data[i].kills} `)
            $("#recentMatches").append(`death: ${data[i].deaths} `)
            $("#recentMatches").append(`assists: ${data[i].assists} `)
            $("#recentMatches").append(``)

            

            console.log( data )
            console.log( textStatus )
            console.log( jqXHR )


            }
        )
    }

}