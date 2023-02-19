import instance from "./axios";

export const MainApi = {
    getBoardList: () => instance.get("/board/getBoardList"),
};