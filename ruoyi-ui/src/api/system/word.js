import request from '@/utils/request'

// 查询汉字大全列表
export function listWord(query) {
  return request({
    url: '/system/word/list',
    method: 'get',
    params: query
  })
}

// 查询汉字大全详细
export function getWord(id) {
  return request({
    url: '/system/word/' + id,
    method: 'get'
  })
}

// 新增汉字大全
export function addWord(data) {
  return request({
    url: '/system/word',
    method: 'post',
    data: data
  })
}

// 修改汉字大全
export function updateWord(data) {
  return request({
    url: '/system/word',
    method: 'put',
    data: data
  })
}

// 删除汉字大全
export function delWord(id) {
  return request({
    url: '/system/word/' + id,
    method: 'delete'
  })
}

// 导出汉字大全
export function exportWord(query) {
  return request({
    url: '/system/word/export',
    method: 'get',
    params: query
  })
}