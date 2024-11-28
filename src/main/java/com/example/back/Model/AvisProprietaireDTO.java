package com.example.back.Model;

public class AvisProprietaireDTO {
    private String contenu;
    private int note;
    private Long clientId;
    private Long proprietaireId;
    private Long reservationId;
    public String getContenu() {
        return contenu;
    }
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    public int getNote() {
        return note;
    }
    public void setNote(int note) {
        this.note = note;
    }
    public Long getClientId() {
        return clientId;
    }
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
    public Long getProprietaireId() {
        return proprietaireId;
    }
    public void setProprietaireId(Long proprietaireId) {
        this.proprietaireId = proprietaireId;
    }
    public Long getReservationId() {
        return reservationId;
    }
    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    
    
    
}
