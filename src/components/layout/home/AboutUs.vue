<template>
    <section id="about-us" class="relative w-full h-1/2 bg-[#F8F9FA]">
        <div class=" container mx-auto p-4 pb-24 h-auto">
            <div class="flex content-center items-center justify-center h-48">
                <h2 class="text-4xl font-extrabold font-['Open_Sans'] my-10">About Us</h2>
            </div>
            <div class="flex flex-wrap md:space-x-12 space-y-4 content-center items-center justify-center h-full">
                <div v-for="card in cards" :key="card.id" class="flex justify-center">
                    <div class="block rounded-lg shadow-lg bg-white max-w-sm max-h-md text-center">
                        <div class="p-6">
                            <img class="mx-auto mb-4" :src="card.src" width="150" alt="logo" />
                            <h5 class="text-gray-900 text-xl font-medium mb-2">{{card.title}}</h5>
                            <p class="text-gray-700 text-base mb-4">
                                {{card.content}}
                            </p>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </section>
</template>

<script>
import GameStore from '../../../assets/img/game-store.svg'
import Game from '../../../assets/img/game.svg'
import Connect from '../../../assets/img/connect.svg'
export default {
    data() {
        return {
            cards: [
                {
                    id: 1,
                    src: GameStore,
                    title: 'Electronic Sports',
                    content: 'Garena is the organizer of major eSports tournaments and events in Southeast Asia, aiming to develop the gaming community.'
                },
                {
                    id: 2,
                    src: Game,
                    title: 'Game',
                    content: 'Garena is a leading game publisher in Southeast Asia. With the platform we provide, users can experience the most engaging and exciting online games on both PC and mobile.'
                },
                {
                    id: 3,
                    src: Connect,
                    title: 'Community',
                    content: 'Players can connect with each other through the Garena platform, update the latest information from the community.'
                }
            ]
        }
    },
}
</script>