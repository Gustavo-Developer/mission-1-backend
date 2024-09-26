package com.example.models;

import java.util.List;

public class Run {
    private String id;
    private String name;
    private String description;
    private double distance;  // Distância em km
    private double averageSpeed;  // Velocidade média em km/h
    private TimeElapsed timeElapsed;  // Tempo total da corrida
    private List<RoutePoint> route;  // Lista de pontos do percurso
    private String image;  // URL ou caminho da imagem
    private String activity;  // Tipo de atividade

    // Construtor vazio
    public Run() {
    }

    // Construtor completo
    public Run(String id, String name, String description, double distance, double averageSpeed, TimeElapsed timeElapsed, List<RoutePoint> route, String image, String activity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.distance = distance;
        this.averageSpeed = averageSpeed;
        this.timeElapsed = timeElapsed;
        this.route = route;
        this.image = image;
        this.activity = activity;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public TimeElapsed getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(TimeElapsed timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    public List<RoutePoint> getRoute() {
        return route;
    }

    public void setRoute(List<RoutePoint> route) {
        this.route = route;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    // Classe interna para representar o tempo decorrido
    public static class TimeElapsed {
        private int hours;
        private int minutes;
        private int seconds;

        public TimeElapsed() {
        }

        public TimeElapsed(int hours, int minutes, int seconds) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        }

        public int getHours() {
            return hours;
        }

        public void setHours(int hours) {
            this.hours = hours;
        }

        public int getMinutes() {
            return minutes;
        }

        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }

        public int getSeconds() {
            return seconds;
        }

        public void setSeconds(int seconds) {
            this.seconds = seconds;
        }
    }

    // Classe interna para representar os pontos da rota
    public static class RoutePoint {
        private double lat;
        private double lng;

        public RoutePoint() {
        }

        public RoutePoint(double lat, double lng) {
            this.lat = lat;
            this.lng = lng;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }
    }
}
