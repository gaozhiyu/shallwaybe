package com.william.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class Geo {
    public final Result results[];
    public final String status;

    @JsonCreator
    public Geo(@JsonProperty("results") Result[] results, @JsonProperty("status") String status){
        this.results = results;
        this.status = status;
    }

    public static final class Result {
        public final Address_component address_components[];
        public final String formatted_address;
        public final Geometry geometry;
        public final String place_id;
        public final String[] types;

        @JsonCreator
        public Result(@JsonProperty("address_components") Address_component[] address_components, @JsonProperty("formatted_address") String formatted_address, @JsonProperty("geometry") Geometry geometry, @JsonProperty("place_id") String place_id, @JsonProperty("types") String[] types){
            this.address_components = address_components;
            this.formatted_address = formatted_address;
            this.geometry = geometry;
            this.place_id = place_id;
            this.types = types;
        }

        public static final class Address_component {
            public final String long_name;
            public final String short_name;
            public final String[] types;
    
            @JsonCreator
            public Address_component(@JsonProperty("long_name") String long_name, @JsonProperty("short_name") String short_name, @JsonProperty("types") String[] types){
                this.long_name = long_name;
                this.short_name = short_name;
                this.types = types;
            }
        }

        public static final class Geometry {
            public final Bounds bounds;
            public final Location location;
            public final String location_type;
            public final Viewport viewport;
    
            @JsonCreator
            public Geometry(@JsonProperty("bounds") Bounds bounds, @JsonProperty("location") Location location, @JsonProperty("location_type") String location_type, @JsonProperty("viewport") Viewport viewport){
                this.bounds = bounds;
                this.location = location;
                this.location_type = location_type;
                this.viewport = viewport;
            }
    
            public static final class Bounds {
                public final Northeast northeast;
                public final Southwest southwest;
        
                @JsonCreator
                public Bounds(@JsonProperty("northeast") Northeast northeast, @JsonProperty("southwest") Southwest southwest){
                    this.northeast = northeast;
                    this.southwest = southwest;
                }
        
                public static final class Northeast {
                    public final double lat;
                    public final double lng;
            
                    @JsonCreator
                    public Northeast(@JsonProperty("lat") double lat, @JsonProperty("lng") double lng){
                        this.lat = lat;
                        this.lng = lng;
                    }
                }
        
                public static final class Southwest {
                    public final double lat;
                    public final double lng;
            
                    @JsonCreator
                    public Southwest(@JsonProperty("lat") double lat, @JsonProperty("lng") double lng){
                        this.lat = lat;
                        this.lng = lng;
                    }
                }
            }
    
            public static final class Location {
                public final double lat;
                public final double lng;
        
                @JsonCreator
                public Location(@JsonProperty("lat") double lat, @JsonProperty("lng") double lng){
                    this.lat = lat;
                    this.lng = lng;
                }
            }
    
            public static final class Viewport {
                public final Northeast northeast;
                public final Southwest southwest;
        
                @JsonCreator
                public Viewport(@JsonProperty("northeast") Northeast northeast, @JsonProperty("southwest") Southwest southwest){
                    this.northeast = northeast;
                    this.southwest = southwest;
                }
        
                public static final class Northeast {
                    public final double lat;
                    public final double lng;
            
                    @JsonCreator
                    public Northeast(@JsonProperty("lat") double lat, @JsonProperty("lng") double lng){
                        this.lat = lat;
                        this.lng = lng;
                    }
                }
        
                public static final class Southwest {
                    public final double lat;
                    public final double lng;
            
                    @JsonCreator
                    public Southwest(@JsonProperty("lat") double lat, @JsonProperty("lng") double lng){
                        this.lat = lat;
                        this.lng = lng;
                    }
                }
            }
        }
    }
}