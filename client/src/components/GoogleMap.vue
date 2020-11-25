<template>
  <b-container class="m-1">
    <GmapMap
      map-type-id="roadmap"
      :zoom="zoom"
      :center="center"
      style="height: 700px; width: 100%"
    >
      <div v-if="propShowList">
        <GmapMarker
          v-for="deal in propDealList"
          :key="deal.dealId"
          :clickable="true"
          :position="{
            lat: parseFloat(deal.houseInfo.lat),
            lng: parseFloat(deal.houseInfo.lng),
          }"
          :icon="{
            url: require('../assets/mark3.png'),
            scaledSize: { width: 30, height: 30 },
          }"
          @click="clickMarker(deal.houseInfo.lat, deal.houseInfo.lng)"
        >
        </GmapMarker>
      </div>
      <div v-else>
        <GmapMarker
          :clickable="true"
          :position="{
            lat: parseFloat(propDeal.houseInfo.lat),
            lng: parseFloat(propDeal.houseInfo.lng),
          }"
          :icon="{
            url: require('../assets/mark3.png'),
            scaledSize: { width: 30, height: 30 },
          }"
          @click="clickMarker(propDeal.houseInfo.lat, propDeal.houseInfo.lng)"
        >
        </GmapMarker>
      </div>
    </GmapMap>
  </b-container>
</template>

<script>
export default {
  props: ['propDealList', 'propShowList', 'propDeal'],
  data() {
    return {
      zoom: 12,
      center: { lat: 37.5326, lng: 127.024612 },
    };
  },
  methods: {},
  watch: {
    propDeal: function() {
      this.center = {
        lat: parseFloat(this.propDeal.houseInfo.lat),
        lng: parseFloat(this.propDeal.houseInfo.lng),
      };
    },
  },
  methods: {
    clickMarker(lat, lng) {
      this.zoom = 15;
      this.center = {
        lat: parseFloat(lat),
        lng: parseFloat(lng),
      };
    },
  },
};
</script>

<style></style>
