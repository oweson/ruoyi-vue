import request from '@/utils/request'

// 查询单词管理列表
export function listEnglishwords(query) {
  return request({
    url: '/system/englishwords/list',
    method: 'get',
    params: query
  })
}

// 查询单词管理详细
export function getEnglishwords(id) {
  return request({
    url: '/system/englishwords/' + id,
    method: 'get'
  })
}

// 新增单词管理
export function addEnglishwords(data) {
  return request({
    url: '/system/englishwords',
    method: 'post',
    data: data
  })
}

// 修改单词管理
export function updateEnglishwords(data) {
  return request({
    url: '/system/englishwords',
    method: 'put',
    data: data
  })
}

// 删除单词管理
export function delEnglishwords(id) {
  return request({
    url: '/system/englishwords/' + id,
    method: 'delete'
  })
}

// 导出单词管理
export function exportEnglishwords(query) {
  return request({
    url: '/system/englishwords/export',
    method: 'get',
    params: query
  })
}