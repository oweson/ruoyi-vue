import request from '@/utils/request'

// 查询成语管理列表
export function listIdiom(query) {
  return request({
    url: '/system/idiom/list',
    method: 'get',
    params: query
  })
}

// 查询成语管理详细
export function getIdiom(id) {
  return request({
    url: '/system/idiom/' + id,
    method: 'get'
  })
}

// 新增成语管理
export function addIdiom(data) {
  return request({
    url: '/system/idiom',
    method: 'post',
    data: data
  })
}

// 修改成语管理
export function updateIdiom(data) {
  return request({
    url: '/system/idiom',
    method: 'put',
    data: data
  })
}

// 删除成语管理
export function delIdiom(id) {
  return request({
    url: '/system/idiom/' + id,
    method: 'delete'
  })
}

// 导出成语管理
export function exportIdiom(query) {
  return request({
    url: '/system/idiom/export',
    method: 'get',
    params: query
  })
}